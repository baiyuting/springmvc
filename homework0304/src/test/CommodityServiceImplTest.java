package test;

import dao.impl.CommodityDAOImpl;
import factory.DAOFactory;
import factory.ServiceFactory;
import org.junit.Test;
import service.ICommodityService;
import service.impl.CommodityServiceImpl;
import vo.Commodity;

import java.sql.SQLException;
import java.util.List;

public class CommodityServiceImplTest {

    @Test
    public void add() throws SQLException {
        Commodity commodity = new Commodity();
        commodity.setName("baiyuting");
        commodity.setPrice(1.0);
        commodity.setFlag(0);
        ICommodityService service = ServiceFactory.getInstance(CommodityServiceImpl.class);
        service.add(commodity);
    }

    @Test
    public void update() throws SQLException {
        Commodity commodity = DAOFactory.getInstance(CommodityDAOImpl.class).findByName("baiyuting");
        commodity.setPrice(1.2);
        ICommodityService service = ServiceFactory.getInstance(CommodityServiceImpl.class);
        service.update(commodity);
    }

    @Test
    public void del() throws SQLException {
        ICommodityService service = ServiceFactory.getInstance(CommodityServiceImpl.class);
        service.delete(1);
    }

    @Test
    public void list() throws SQLException {
        ICommodityService service = ServiceFactory.getInstance(CommodityServiceImpl.class);
        List<Commodity> list = service.list(null,null, 1,2);
        System.out.println(list);
    }

    @Test
    public void list2() throws SQLException {
        ICommodityService service = ServiceFactory.getInstance(CommodityServiceImpl.class);
        List<Commodity> list = service.list("name","bai", 1,2);
        System.out.println(list);
    }



}
