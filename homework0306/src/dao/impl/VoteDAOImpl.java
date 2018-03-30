package dao.impl;

import dao.IUserDAO;
import dao.IVoteDAO;
import util.DatabaseConnection;
import vo.User;
import vo.Vote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteDAOImpl implements IVoteDAO {


    private Connection conn;
    private PreparedStatement pstmt;

    public VoteDAOImpl() {
        conn = DatabaseConnection.get();
    }

    @Override
    public Vote findByUserIdAndItemId(Integer userId, Integer itemId) throws SQLException {
        Vote vote = null;
        String sql = "SELECT id,user_id,item_id FROM vote WHERE user_id=? AND item_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setInt(2, itemId);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next())
            vote = new Vote(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
        return vote;
    }

    @Override
    public Integer add(Vote vote) throws SQLException {
        Integer amount = 0;
        String sql = "insert into vote(user_id,item_id) values(?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,vote.getUserId());
        pstmt.setInt(2, vote.getItemId());
        amount = pstmt.executeUpdate();
        return amount;
    }
}
