package servlet;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import factory.ServiceFactory;
import service.INewsService;
import service.impl.NewsServiceImpl;
import vo.News;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String requestContextType = request.getContentType();    // 取得当前的表单模式
        if (null != user && requestContextType != null && requestContextType.contains("multipart/form-data")) {// 表示表单封装
            SmartUpload smart = new SmartUpload();
            // 表单一旦被封装就意味着有可能进行文件的上传处理，就要准备好SmartUpload组件，但是这个组件最终肯定还是交给各个Action去操作
            smart.initialize(super.getServletConfig(), request, response);
            try {
                smart.upload();
                StringBuilder imgs = new StringBuilder();
                SmartFiles files = smart.getFiles();
                for (int i = 0; i < files.getCount(); i++) {
                    SmartFile file = files.getFile(i);
                    String img = "/upload/" + UUID.randomUUID() + "." + file.getFileExt();
                    file.saveAs(this.getServletContext().getRealPath("/") + img);
                    imgs.append(img + ",");
                }
                if (imgs.length() > 0)
                    imgs.deleteCharAt(imgs.lastIndexOf(","));
                //只有级别为 0 的用户才能够发布消息
                INewsService service = ServiceFactory.getInstance(NewsServiceImpl.class);
                News news = new News();
                news.setTitle(smart.getRequest().getParameter("title"));
                news.setPublishTime(Calendar.getInstance().getTime());
                news.setSummary(smart.getRequest().getParameter("summary"));
                news.setContent(smart.getRequest().getParameter("content"));
                news.setImgs(imgs.toString());
                try {
                    service.add(user, news);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SmartUploadException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("/list?currentPage=1&lineSize=2&auditStatus=0").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
