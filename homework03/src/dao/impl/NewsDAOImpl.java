package dao.impl;

import dao.INewsDAO;
import util.DatabaseConnection;
import vo.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "SELECT id,title,publish_time,summary,content,imgs, audit_status,audit_date,audit_user_id,audit_fail_reason from news where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            vo = new News(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getString(10));
        }
        return vo;
    }

    @Override
    public Integer add(News vo) throws SQLException {
        String sql = "insert into news(title,publish_time,summary,content,imgs) VALUES(?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, new java.sql.Date(vo.getPublishTime().getTime()));
        pstmt.setString(3, vo.getSummary());
        pstmt.setString(4, vo.getContent());
        pstmt.setString(5, (null == vo.getImgs()) ? "" : vo.getImgs());
        int result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public Integer update(News vo) throws SQLException {
        String sql = "UPDATE news set title=?,publish_time=?,summary=?,content=?,imgs=?,audit_status=?,audit_date=?,audit_user_id=?,audit_fail_reason=? where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, new java.sql.Date(vo.getPublishTime().getTime()));
        pstmt.setString(3, vo.getSummary());
        pstmt.setString(4, vo.getContent());
        pstmt.setString(5, vo.getImgs());
        pstmt.setInt(6, vo.getAuditStatus());
        if (vo.getAuditDate() != null) {
            pstmt.setDate(7, new java.sql.Date(vo.getAuditDate().getTime()));
        } else {
            pstmt.setDate(7, null);
        }
        if (vo.getAuditUserId() != -1) {//具有审核人
            pstmt.setInt(8, vo.getAuditUserId());
        } else {//不具有审核人
            pstmt.setInt(8, -1);
        }
        pstmt.setString(9, vo.getAuditFailReason());
        pstmt.setInt(10, vo.getId());
        int result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public List<News> list(Integer auditStatus, Integer currentPage, Integer lineSize) throws SQLException {
        List<News> all = new ArrayList<News>();
        String sql = null;
        sql = "SELECT id,title,publish_time,summary,content,imgs,audit_status,audit_date,audit_user_id,audit_fail_reason from news where audit_status=? LIMIT ?,?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, auditStatus);
        pstmt.setInt(2, (currentPage - 1) * lineSize);
        pstmt.setInt(3, lineSize);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            News vo = new News(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getString(10));
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
