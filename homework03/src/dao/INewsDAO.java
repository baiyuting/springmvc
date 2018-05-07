package dao;

import vo.News;

import java.sql.SQLException;
import java.util.List;

public interface INewsDAO {
    /**
     * 根据id获取新闻消息
     *
     * @param id
     * @return
     */
    News findById(Integer id) throws SQLException;

    /**
     * 发布新闻新闻
     *
     * @param news
     * @return
     */
    Integer add(News news) throws SQLException;

    /**
     * 更改新闻
     *
     * @param news
     * @return
     */
    Integer update(News news) throws SQLException;

    /**
     * 新闻审核状态
     *
     * @param auditStatus
     * @param currentPage
     * @param lineSize
     * @return
     */
    List<News> list(Integer auditStatus, Integer currentPage, Integer lineSize) throws SQLException;

    /**
     * 统计新闻数量
     *
     * @param auditStatus
     * @return
     */
    Integer count(Integer auditStatus) throws SQLException;
}
