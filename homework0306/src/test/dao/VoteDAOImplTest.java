package test.dao;

import dao.impl.ItemDAOImpl;
import dao.impl.VoteDAOImpl;
import factory.DAOFactory;
import org.junit.Test;
import vo.Item;
import vo.Vote;

import java.sql.SQLException;
import java.util.List;

public class VoteDAOImplTest {

    @Test
    public void findByUserIdAndItemId() throws SQLException {
        Vote vote = DAOFactory.getInstance(VoteDAOImpl.class).findByUserIdAndItemId(1, 1);
        System.out.println(vote);
    }

    @Test
    public void add() throws SQLException {
        for (int i = 0; i < 3; i++) {
            Vote vote = new Vote();
            vote.setUserId(1);
            vote.setItemId(i+1);
            Integer amount = DAOFactory.getInstance(VoteDAOImpl.class).add(vote);
            System.out.println(amount);
        }
    }

}
