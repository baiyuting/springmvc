package service.impl;

import dao.impl.UserDAOImpl;
import factory.DAOFactory;
import service.IUserService;
import vo.User;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    @Override
    public User findById(Integer id) throws SQLException {
        return DAOFactory.getInstance(UserDAOImpl.class).findById(id);
    }
}
