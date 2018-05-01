package service;

import vo.Menu;

import java.sql.SQLException;
import java.util.List;

public interface IMenuService {

    List<Menu> findNextMenus(int menuId) throws SQLException;
}
