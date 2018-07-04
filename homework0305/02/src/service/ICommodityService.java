package service;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import vo.Commodity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICommodityService {

    /**
     * 可以实现商品信息的发布处理操作，在进行商品信息发布的时候要求商品名称不得重复
     *
     * @param commodity
     * @return
     */
    boolean add(Commodity commodity) throws SQLException;

    /**
     * 可以实现商品信息的修改与删除操作；
     *
     * @param commodity
     * @return
     */
    boolean update(Commodity commodity) throws SQLException;

    /**
     * 可以实现商品信息的修改与删除操作；
     *
     * @param id
     * @return
     */
    boolean delete(Integer id) throws SQLException;

    /**
     * 可以进行商品信息的模糊查询，在进行模糊查询时如果没有输入查询关键字，则实现查询全部处理，考虑到商品数量较多，可以采用分页的形式实现。
     *
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     */
    List<Commodity> list(String column, String keyWord, int currentPage,
                         int lineSize) throws SQLException;
}
