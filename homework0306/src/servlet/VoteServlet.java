package servlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import factory.ServiceFactory;
import service.IVoteService;
import service.impl.VoteServiceImpl;
import vo.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/vote")
public class VoteServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Integer res = 0;
        IVoteService voteService = ServiceFactory.getInstance(VoteServiceImpl.class);
        try {
            User user = (User) request.getSession().getAttribute("user");
            res = voteService.addVotedItem(user.getId(), Integer.parseInt(request.getParameter("itemId")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().print(res);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
