package dao;

import vo.Content;
import vo.Item;

import java.sql.SQLException;
import java.util.List;

public interface IItemDAO {
    /**
     * 根据content_id查询 投票项 集合
     *
     * @param contentId
     * @return
     */
    List<Item> findByContentId(Integer contentId) throws SQLException;

    /**
     * 添加投票项
     *
     * @param item
     * @return
     */
    Integer add(Item item) throws SQLException;

}
