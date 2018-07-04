package dao;

import vo.User;

import java.sql.SQLException;

public interface IUserDAO {
    /**
     * 根据id查询商品
     *
     * @param id
     * @return
     */
    User findById(Integer id) throws SQLException;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Integer add(User user) throws SQLException;

}
