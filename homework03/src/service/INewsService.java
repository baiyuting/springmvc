package service;

import vo.News;
import vo.User;

import java.sql.SQLException;
import java.util.List;

public interface INewsService {

    /**
     * 根据 id 查找 news
     *
     * @param id
     * @return
     */
    News findById(Integer id) throws SQLException;

    /**
     * 新闻发布用户可以进行新闻发布处理，但是发布的新闻不允许前台用户浏览
     *
     * @param user 新闻发布用户
     * @param vo
     * @return
     */
    boolean add(User user, News vo) throws SQLException;

    /**
     * 新闻审核用户可以对发布的新闻进行审核，审核通过后前台用户可以进行浏览；
     *
     * @param user 新闻审核用户
     * @param vo
     * @return
     */
    boolean update(User user, News vo) throws SQLException;


    /**
     * 新闻浏览时要求可以采用分页的形式完成显示。
     *
     * @param auditStatus
     * @param currentPage
     * @param lineSize
     * @return
     */
    List<News> list(Integer auditStatus, int currentPage,
                    int lineSize) throws SQLException;

    /**
     * 统计新闻数量
     *
     * @param auditStatus
     * @return
     */
    Integer count(Integer auditStatus) throws SQLException;
}
