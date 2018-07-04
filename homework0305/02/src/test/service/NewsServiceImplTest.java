package test.service;

import dao.impl.NewsDAOImpl;
import dao.impl.UserDAOImpl;
import factory.DAOFactory;
import factory.ServiceFactory;
import org.junit.Test;
import service.INewsService;
import service.impl.NewsServiceImpl;
import vo.News;
import vo.User;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class NewsServiceImplTest {

    @Test
    public void add() throws SQLException {
        News news = new News();
        news.setTitle("hello5");
        news.setPublishTime(Calendar.getInstance().getTime());
        news.setKeyword("hello5");
        news.setContent("content5");
        INewsService service = ServiceFactory.getInstance(NewsServiceImpl.class);
        User user = DAOFactory.getInstance(UserDAOImpl.class).findById(2);
        service.add(user, news);
    }

    @Test
    public void update() throws SQLException {
        NewsDAOImpl newsDAO = DAOFactory.getInstance(NewsDAOImpl.class);
        News result = newsDAO.findById(2);
        User user = DAOFactory.getInstance(UserDAOImpl.class).findById(1);
        INewsService service = ServiceFactory.getInstance(NewsServiceImpl.class);
        result.setAuditStatus(1);
        service.update(user, result);
    }

    @Test
    public void list() throws SQLException {
        INewsService service = ServiceFactory.getInstance(NewsServiceImpl.class);
        List<News> list = service.list(0, 1, 2);
        System.out.println(list);
    }


}
