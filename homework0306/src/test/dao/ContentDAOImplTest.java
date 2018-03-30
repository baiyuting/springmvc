package test.dao;

import dao.impl.ContentDAOImpl;
import dao.impl.UserDAOImpl;
import factory.DAOFactory;
import org.junit.Test;
import util.DatabaseConnection;
import util.PasswordUtil;
import vo.Content;
import vo.User;

import java.sql.SQLException;
import java.util.List;

public class ContentDAOImplTest {

    @Test
    public void list() throws SQLException {
        List<Content> list = DAOFactory.getInstance(ContentDAOImpl.class).list(1, 3);
        System.out.println(list);
    }

    @Test
    public void add() throws SQLException {
        Content content = new Content();
        for (int i = 0; i < 3; i++) {
            content.setContent("content" + i);
            content.setImg("img" + i);
            Integer amount = DAOFactory.getInstance(ContentDAOImpl.class).add(content);
            System.out.println(amount);
        }
    }

    @Test
    public void count() throws SQLException {
        System.out.println(DAOFactory.getInstance(ContentDAOImpl.class).count());
    }

}
