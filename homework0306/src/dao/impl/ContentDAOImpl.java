package dao.impl;

import dao.IContentDAO;
import dao.IUserDAO;
import util.DatabaseConnection;
import vo.Content;
import vo.User;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContentDAOImpl implements IContentDAO {


    private Connection conn ;
    private PreparedStatement pstmt ;

    public ContentDAOImpl() {
        conn = DatabaseConnection.get();
    }


    @Override
    public List<Content> list(Integer pageNo, Integer pageSize) throws SQLException {
        List<Content> list = new ArrayList<>();
        String sql = "select id,content,img from content limit ?,?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (pageNo - 1) * pageSize);
        pstmt.setInt(2, pageSize);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            list.add(new Content(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }
        return list;
    }

    @Override
    public Integer add(Content content) throws SQLException {
        Integer amount = 0;
        String sql = "insert into content(content,img) values(?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, content.getContent());
        pstmt.setString(2, content.getImg());
        amount = pstmt.executeUpdate();
        return amount;
    }

    @Override
    public Integer count() throws SQLException {
        Integer total = 0;
        String sql = "select count(*) from content";
        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next())
            total = resultSet.getInt(1);
        return total;
    }
}
