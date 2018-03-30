package servlet;

import dto.VoteInfoDTO;
import factory.ServiceFactory;
import service.IUserService;
import service.IVoteService;
import service.impl.UserServiceImpl;
import service.impl.VoteServiceImpl;
import util.PasswordUtil;
import vo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.annotation.WebServlet;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer pageNo = (null != request.getParameter("pageNo") && request.getParameter("pageNo").matches("\\d+")) ? Integer.parseInt(request.getParameter("pageNo")) : 1;
        Integer pageSize = (null != request.getParameter("pageSize") && request.getParameter("pageSize").matches("\\d+")) ? Integer.parseInt(request.getParameter("pageSize")) : 2;
        IVoteService voteService = ServiceFactory.getInstance(VoteServiceImpl.class);
        try {
            List<VoteInfoDTO> list = voteService.list(user.getId(), pageNo, pageSize);
            request.setAttribute("list", list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        try {
            request.setAttribute("total", voteService.count());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/pages/list.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
