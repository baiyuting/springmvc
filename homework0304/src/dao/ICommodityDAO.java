package dao;

import vo.Commodity;

import java.sql.SQLException;
import java.util.List;

public interface ICommodityDAO {
    /**
     * 根据id查询商品
     *
     * @param name
     * @return
     */
    Commodity findByName(String name) throws SQLException;

    /**
     * 实现商品信息的发布处理操作
     *
     * @param vo
     * @return
     */
    boolean add(Commodity vo) throws SQLException;

    /**
     * 实现商品信息的修改操作
     *
     * @param vo
     * @return
     */
    boolean update(Commodity vo) throws SQLException;

    /**
     * 实现商品信息的删除操作
     *
     * @param id
     * @return
     */
    boolean delById(Integer id) throws SQLException;

    /**
     * 则实现查询全部处理，采用分页的形式实现
     *
     * @param currentPage
     * @param lineSize
     * @return
     */
    List<Commodity> queryAll(Integer currentPage, Integer lineSize) throws SQLException;

    /**
     * 输入查询关键字进行模糊查询，采用分页的形式实现
     *
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     */
    List<Commodity> queryAllByColumn(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException;
}
