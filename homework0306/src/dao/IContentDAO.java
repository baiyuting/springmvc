package dao;

import vo.Content;
import vo.User;

import java.sql.SQLException;
import java.util.List;

public interface IContentDAO {
    /**
     * 分页查询 content
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Content> list(Integer pageNo, Integer pageSize) throws SQLException;

    /**
     * 添加投票内容
     *
     * @param content
     * @return
     */
    Integer add(Content content) throws SQLException;

    /**
     * 查询投票信息总数
     *
     * @return
     */
    Integer count() throws SQLException;

}
