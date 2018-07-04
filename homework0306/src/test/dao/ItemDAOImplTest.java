package test.dao;

import dao.impl.ContentDAOImpl;
import dao.impl.ItemDAOImpl;
import factory.DAOFactory;
import org.junit.Test;
import vo.Content;
import vo.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemDAOImplTest {

    @Test
    public void findByContentId() throws SQLException {
        List<Item> list = DAOFactory.getInstance(ItemDAOImpl.class).findByContentId(1);
        System.out.println(list);
    }

    @Test
    public void add() throws SQLException {
        for (int i=0;i<3;i++){
            Item item = new Item();
            item.setContentId(1);
            item.setItem("item"+i);
            Integer amount = DAOFactory.getInstance(ItemDAOImpl.class).add(item);
            System.out.println(amount);
        }
    }

}
