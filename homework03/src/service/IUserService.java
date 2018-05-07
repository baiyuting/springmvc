package service;

import vo.User;

import java.sql.SQLException;

public interface IUserService {

    /**
     * 根据id 查找用户
     *
     * @param id
     * @return
     */
    User findById(Integer id) throws SQLException;

}
