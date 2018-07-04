package servlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import dto.VoteInfoDTO;
import factory.ServiceFactory;
import service.IVoteService;
import service.impl.VoteServiceImpl;
import vo.Content;
import vo.Item;
import vo.User;

import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/add")
public class AddServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String requestContextType = request.getContentType();    // 取得当前的表单模式
        if (requestContextType != null && requestContextType.contains("multipart/form-data")) {// 表示表单封装
            SmartUpload smart = new SmartUpload();
            // 表单一旦被封装就意味着有可能进行文件的上传处理，就要准备好SmartUpload组件，但是这个组件最终肯定还是交给各个Action去操作
            smart.initialize(super.getServletConfig(), request, response);
            try {
                smart.upload();
                String img = "/upload/" + UUID.randomUUID() + "." + smart.getFiles().getFile(0).getFileExt();
                String content = smart.getRequest().getParameter("content");
                smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/") + img);
                String items = smart.getRequest().getParameter("items");

                IVoteService voteService = ServiceFactory.getInstance(VoteServiceImpl.class);
                voteService.addVoteInfo(img, content, items);
            } catch (SmartUploadException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("list?pageNo=1&pageSize=2").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
