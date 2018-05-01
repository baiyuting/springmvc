package service.impl;

import dao.IMenuDAO;
import dao.impl.MenuDAOImpl;
import factory.DAOFactory;
import service.IMenuService;
import vo.Menu;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements IMenuService {
    @Override
    public List<Menu> findNextMenus(int menuId) throws SQLException {
        IMenuDAO dao = DAOFactory.getInstance(MenuDAOImpl.class);
        return  dao.findByPid(menuId);
    }
}
