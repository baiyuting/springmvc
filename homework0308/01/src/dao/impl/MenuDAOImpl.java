package dao.impl;

import dao.IMenuDAO;
import util.DatabaseConnection;
import vo.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements IMenuDAO {

    private Connection conn;
    private PreparedStatement pstmt;

    public MenuDAOImpl() {
        conn = DatabaseConnection.get();
    }


    @Override
    public List<Menu> findByPid(int pid) throws SQLException {
        List<Menu> list = new ArrayList<>();
        String sql = "select mid,title,pid from menu where pid=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, pid);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next())
            list.add(new Menu(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
        return list;
    }

    @Override
    public Menu findByMid(int mid) throws SQLException {
        Menu menu = null;
        String sql = "select mid,title,pid from menu where mid=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, mid);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next())
            menu = new Menu(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
        return menu;
    }
}
