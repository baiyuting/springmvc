package dao.impl;

import dao.IContentDAO;
import dao.IItemDAO;
import util.DatabaseConnection;
import vo.Content;
import vo.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements IItemDAO {


    private Connection conn ;
    private PreparedStatement pstmt ;

    public ItemDAOImpl() {
        conn = DatabaseConnection.get();
    }

    @Override
    public List<Item> findByContentId(Integer contentId) throws SQLException {
        List<Item> list = new ArrayList<>();
        String sql = "select id,content_id,item from item where content_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, contentId);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            list.add(new Item(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3)));
        }
        return list;
    }

    @Override
    public Integer add(Item item) throws SQLException {
        Integer amount = 0;
        String sql = "insert into item(content_id,item) values(?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, item.getContentId());
        pstmt.setString(2, item.getItem());
        amount = pstmt.executeUpdate();
        return amount;
    }
}
