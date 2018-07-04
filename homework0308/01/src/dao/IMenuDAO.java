package dao;

import vo.Menu;

import java.sql.SQLException;
import java.util.List;

public interface IMenuDAO {

    List<Menu> findByPid(int pid) throws SQLException;

    Menu findByMid(int mid) throws SQLException;

}
