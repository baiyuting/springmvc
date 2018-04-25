package test.dao;

import dao.impl.UserDAOImpl;
import factory.DAOFactory;
import org.junit.Test;
import util.DatabaseConnection;
import util.PasswordUtil;
import vo.User;

import java.sql.SQLException;

public class UserDAOImplTest {

    @Test
    public void findById() throws SQLException {
        User user = DAOFactory.getInstance(UserDAOImpl.class).findById(1);
        System.out.println(user);
        DatabaseConnection.close();
    }

    @Test
    public void add() throws SQLException {
//        User user = new User();
//        user.setPassword(PasswordUtil.getPassword("123"));
//
//        DAOFactory.getInstance(UserDAOImpl.class).add(user);
//        System.out.println(user);
//        DatabaseConnection.close();

        System.out.println(PasswordUtil.getPassword("123"));

        System.out.println(Integer.parseInt("001"));
    }

    @Test
    public void add2() throws SQLException {
        User user = new User();
        user.setGrade(0);
        user.setPassword(PasswordUtil.getPassword("123"));

        DAOFactory.getInstance(UserDAOImpl.class).add(user);
        System.out.println(user);
        DatabaseConnection.close();
    }
}
