package dao;

import vo.User;
import vo.Vote;

import java.sql.SQLException;

public interface IVoteDAO {
    /**
     * 根据user_id和item_id查询
     *
     * @param userId
     * @param itemId
     * @return
     */
    Vote findByUserIdAndItemId(Integer userId, Integer itemId) throws SQLException;

    /**
     * 添加投票用户投票信息
     *
     * @param vote
     * @return
     */
    Integer add(Vote vote) throws SQLException;

}
