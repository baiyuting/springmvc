package servlet;

import factory.ServiceFactory;
import service.INewsService;
import service.IUserService;
import service.impl.NewsServiceImpl;
import service.impl.UserServiceImpl;
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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            //只有级别为 1 的用户才能够审核消息
            INewsService newsService = ServiceFactory.getInstance(NewsServiceImpl.class);
            try {
                News news = newsService.findById(Integer.parseInt(request.getParameter("newsId")));
                news.setAuditStatus(Integer.parseInt(request.getParameter("auditStatus")));
                news.setAuditDate(Calendar.getInstance().getTime());
                news.setAuditUserId(user.getId());
                news.setAuditFailReason(request.getParameter("auditFailReason"));
                newsService.update(user, news);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("/list?currentPage=1&lineSize=2&auditStatus=0").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
