package test.dao;

import dao.IMenuDAO;
import dao.impl.MenuDAOImpl;
import factory.DAOFactory;
import org.junit.Test;
import util.DatabaseConnection;
import vo.Menu;

import java.sql.SQLException;
import java.util.List;

public class MenuDAOImplTest {

    @Test
    public void findByPid() throws SQLException {
        IMenuDAO dao = DAOFactory.getInstance(MenuDAOImpl.class);
        List<Menu> list = dao.findByPid(1);
        System.out.println(list);
        DatabaseConnection.close();
    }


    @Test
    public void findByMid() throws SQLException {
        Menu menu = DAOFactory.getInstance(MenuDAOImpl.class).findByMid(1);
        System.out.println(menu);
        DatabaseConnection.close();
    }

}
