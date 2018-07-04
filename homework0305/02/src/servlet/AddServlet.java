package servlet;

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

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            //只有级别为 0 的用户才能够发布消息
            INewsService service = ServiceFactory.getInstance(NewsServiceImpl.class);
            News news = new News();
            news.setTitle(request.getParameter("title"));
            news.setPublishTime(Calendar.getInstance().getTime());
            news.setKeyword(request.getParameter("keyword"));
            news.setContent(request.getParameter("content"));
            try {
                service.add(user, news);
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
