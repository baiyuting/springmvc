package dao.impl;

import dao.IUserDAO;
import util.DatabaseConnection;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements IUserDAO {


    private Connection conn ;
    private PreparedStatement pstmt ;

    public UserDAOImpl() {
        conn = DatabaseConnection.get();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        String sql = "select id,password,grade from user where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
        return user;
    }

    @Override
    public Integer add(User user) throws SQLException {
        String sql = "insert into user(password, grade) values(?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getPassword());
        pstmt.setInt(2, user.getGrade());
        int result = pstmt.executeUpdate();
        return result;
    }
}
