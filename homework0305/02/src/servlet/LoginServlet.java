package servlet;

import factory.ServiceFactory;
import service.INewsService;
import service.IUserService;
import service.impl.NewsServiceImpl;
import service.impl.UserServiceImpl;
import util.PasswordUtil;
import vo.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        password = PasswordUtil.getPassword(password);//获取加密后的密码
        if (id.matches("\\d+")) { // 如果id 是由数字构成的
            IUserService service = ServiceFactory.getInstance(UserServiceImpl.class);
            try {
                User user = service.findById(Integer.parseInt(id));
                if (null != user && user.getPassword().equals(password))//验证成功
                    request.getSession().setAttribute("user", user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/list?currentPage=1&lineSize=2").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
