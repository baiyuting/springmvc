package dao.impl;

import dao.INewsDAO;
import util.DatabaseConnection;
import vo.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDAOImpl implements INewsDAO {


    private Connection conn;
    private PreparedStatement pstmt;

    public NewsDAOImpl() {
        conn = DatabaseConnection.get();
    }

    @Override
    public News findById(Integer id) throws SQLException {
        News vo = null;
        String sql = "SELECT id,title,publish_time,keyword,content,audit_status,audit_date,audit_user_id,audit_fail_reason from news where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            vo = new News(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getString(9));
        }
        return vo;
    }

    @Override
    public Integer add(News vo) throws SQLException {
        String sql = "insert into news(title,publish_time,keyword,content) VALUES(?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, new java.sql.Date(vo.getPublishTime().getTime()));
        pstmt.setString(3, vo.getKeyword());
        pstmt.setString(4, vo.getContent());
        int result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public Integer update(News vo) throws SQLException {
        String sql = "UPDATE news set title=?,publish_time=?,keyword=?,content=?,audit_status=?,audit_date=?,audit_user_id=?,audit_fail_reason=? where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, new java.sql.Date(vo.getPublishTime().getTime()));
        pstmt.setString(3, vo.getKeyword());
        pstmt.setString(4, vo.getContent());
        pstmt.setInt(5, vo.getAuditStatus());
        if (vo.getAuditDate() != null) {
            pstmt.setDate(6, new java.sql.Date(vo.getAuditDate().getTime()));
        } else {
            pstmt.setDate(6, null);
        }
        if (vo.getAuditUserId() != -1) {//具有审核人
            pstmt.setInt(7, vo.getAuditUserId());
        } else {//不具有审核人
            pstmt.setInt(7, -1);
        }
        pstmt.setString(8, vo.getAuditFailReason());
        pstmt.setInt(9, vo.getId());
        int result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public List<News> list(Integer auditStatus, Integer currentPage, Integer lineSize) throws SQLException {
        List<News> all = new ArrayList<News>();
        String sql = null;
        sql = "SELECT id,title,publish_time,keyword,content,audit_status,audit_date,audit_user_id,audit_fail_reason from news where audit_status=? LIMIT ?,?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, auditStatus);
        pstmt.setInt(2, (currentPage - 1) * lineSize);
        pstmt.setInt(3, lineSize);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            News vo = new News(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getString(9));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer count(Integer auditStatus) throws SQLException {
        Integer count = 0;
        String sql = "SELECT count(*) from news where audit_status=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, auditStatus);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
}
