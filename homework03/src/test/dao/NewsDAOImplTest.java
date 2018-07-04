package test.dao;

import dao.impl.NewsDAOImpl;
import factory.DAOFactory;
import org.junit.Test;
import util.DatabaseConnection;
import vo.News;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class NewsDAOImplTest {

    @Test
    public void findById() throws SQLException {
        News result = DAOFactory.getInstance(NewsDAOImpl.class).findById(1);
        System.out.println(result);
        DatabaseConnection.close();
    }

    @Test
    public void add() throws SQLException {
        News news = new News();
        news.setTitle("hello4");
        news.setPublishTime(Calendar.getInstance().getTime());
        news.setSummary("hello4");
        news.setContent("content4");
        int result = DAOFactory.getInstance(NewsDAOImpl.class).add(news);
        System.out.println(result);
        DatabaseConnection.close();
    }


    @Test
    public void update() throws SQLException {
        NewsDAOImpl newsDAO = DAOFactory.getInstance(NewsDAOImpl.class);
        News result = newsDAO.findById(1);
        result.setAuditStatus(1);
        newsDAO.update(result);
        DatabaseConnection.close();
    }

    @Test
    public void list() throws SQLException {
        NewsDAOImpl newsDAO = DAOFactory.getInstance(NewsDAOImpl.class);
        List<News> list = newsDAO.list(0, 1,2);
        System.out.println(list);
        DatabaseConnection.close();
    }

    @Test
    public void count() throws SQLException {
        Integer count = DAOFactory.getInstance(NewsDAOImpl.class).count(1);
        System.out.println(count);
        DatabaseConnection.close();
    }
}
