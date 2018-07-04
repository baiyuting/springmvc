package service;

import dto.VoteInfoDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IVoteService {

    /**
     * 查询列表信息，包含 投票内容，投票项，用户是否投过票信息
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<VoteInfoDTO> list(Integer userId, Integer pageNo, Integer pageSize) throws SQLException;

    /**
     * 查询投票信息总数
     *
     * @return
     */
    Integer count() throws SQLException;

    /**
     * 添加投票信息
     *
     * @return
     */
    void addVoteInfo(String img, String content, String items) throws SQLException, IOException;

    /**
     * 用户投票
     *
     * @return
     */
    Integer addVotedItem(Integer userId, Integer itemId) throws SQLException;
}
