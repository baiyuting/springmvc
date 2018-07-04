package test.service;

import factory.ServiceFactory;
import org.junit.Test;
import service.IMenuService;
import service.impl.MenuServiceImpl;

import java.sql.SQLException;

public class ServiceImplTest {

    @Test
    public void findByPid() throws SQLException {
        IMenuService menuService = ServiceFactory.getInstance(MenuServiceImpl.class);
        System.out.println(menuService.findNextMenus(1));
    }
}
