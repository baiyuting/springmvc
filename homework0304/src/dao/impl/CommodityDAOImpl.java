package dao.impl;

import dao.ICommodityDAO;
import util.DatabaseConnection;
import vo.Commodity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDAOImpl implements ICommodityDAO {

    private Connection conn ;
    private PreparedStatement pstmt ;

    public CommodityDAOImpl() {
        conn = DatabaseConnection.get();
    }

    @Override
    public Commodity findByName(String name) throws SQLException {
        Commodity commodity = null;
        String sql = "select id,name,price,flag from commodity where name=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            commodity = new Commodity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
        }
        return commodity;
    }

    @Override
    public boolean add(Commodity vo) throws SQLException {
        String sql = "insert into commodity(name,price,flag) VALUES(?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getName());
        pstmt.setDouble(2, vo.getPrice());
        pstmt.setInt(3, vo.getFlag());
        int result = pstmt.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean update(Commodity vo) throws SQLException {
        String sql = "update commodity set name=?,price=?,flag=? where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getName());
        pstmt.setDouble(2, vo.getPrice());
        pstmt.setInt(3, vo.getFlag());
        pstmt.setInt(4, vo.getId());
        int result = pstmt.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean delById(Integer id) throws SQLException {
        String sql = "update commodity set flag=4 where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Commodity> queryAll(Integer currentPage, Integer lineSize) throws SQLException {
        List<Commodity> all = new ArrayList<Commodity>();
        String sql = "SELECT id,name,price,flag from commodity where flag!=4 LIMIT ?,?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (currentPage - 1) * lineSize);
        pstmt.setInt(2, lineSize);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Commodity vo = new Commodity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Commodity> queryAllByColumn(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Commodity> all = new ArrayList<Commodity>();
        String sql = "SELECT id,name,price,flag from commodity where flag!=4 and " + column + " LIKE ? LIMIT ?,?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + keyWord + "%");
        pstmt.setInt(2, (currentPage - 1) * lineSize);
        pstmt.setInt(3, lineSize);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Commodity vo = new Commodity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
            all.add(vo);
        }
        return all;
    }
}
