package servlet;

import dto.NewsDTO;
import factory.ServiceFactory;
import service.INewsService;
import service.impl.NewsServiceImpl;
import vo.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        INewsService service = ServiceFactory.getInstance(NewsServiceImpl.class);
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
        Integer lineSize = Integer.parseInt(request.getParameter("lineSize"));
        List<News> list = null;
        Integer count = 0;
        Integer auditStatus = 1;//默认审核状态
        try {
            if (request.getParameter("auditStatus") != null && request.getSession().getAttribute("user") != null) { // 用户在登录状态下获取审核状态信息
                auditStatus = Integer.parseInt(request.getParameter("auditStatus"));
            }
            list = service.list(auditStatus, currentPage, lineSize);
            count = service.count(auditStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<NewsDTO> dtos = new ArrayList<>();
        for (News news:list){
            dtos.add(new NewsDTO(news));
        }
        request.setAttribute("list", dtos);
        request.setAttribute("count", count);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("auditStatus", auditStatus);
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/pages/front/list.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/back/list.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
