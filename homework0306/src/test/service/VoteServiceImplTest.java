package test.service;

import dto.VoteInfoDTO;
import factory.ServiceFactory;
import org.junit.Test;
import service.IVoteService;
import service.impl.VoteServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class VoteServiceImplTest {

    @Test
    public void list() throws SQLException {
        IVoteService voteService = ServiceFactory.getInstance(VoteServiceImpl.class);
        List<VoteInfoDTO> list = voteService.list(1, 1, 2);
        System.out.println(list);
    }
}
