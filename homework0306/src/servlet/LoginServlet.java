package servlet;

import factory.ServiceFactory;
import service.IUserService;
import service.impl.UserServiceImpl;
import util.PasswordUtil;
import vo.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        password = PasswordUtil.getPassword(password);//获取加密后的密码
        User user = null;
        if (id.matches("\\d+")) { // 如果id 是由数字构成的
            IUserService service = ServiceFactory.getInstance(UserServiceImpl.class);
            try {
                user = service.findById(Integer.parseInt(id));
                if (null != user && user.getPassword().equals(password))//验证成功
                    request.getSession().setAttribute("user", user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String url = "/index.jsp";//默认返回登录页
        if (null != user)
            url = "list?pageNo=1&pageSize=2";//如果有数据，进入列表页
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
