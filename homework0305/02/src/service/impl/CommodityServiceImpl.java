package service.impl;

import dao.ICommodityDAO;
import dao.impl.CommodityDAOImpl;
import factory.DAOFactory;
import service.ICommodityService;
import vo.Commodity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityServiceImpl implements ICommodityService {
    @Override
    public boolean add(Commodity commodity) throws SQLException {
        boolean result = false;
        ICommodityDAO commodityDAO = DAOFactory.getInstance(CommodityDAOImpl.class);
        Commodity temp = commodityDAO.findByName(commodity.getName());
        if (null == temp) {
            result = commodityDAO.add(commodity);
        }
        return result;
    }

    @Override
    public boolean update(Commodity commodity) throws SQLException {
        return DAOFactory.getInstance(CommodityDAOImpl.class).update(commodity);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return DAOFactory.getInstance(CommodityDAOImpl.class).delById(id);
    }

    @Override
    public List<Commodity> list(String column, String keyWord, int currentPage, int lineSize) throws SQLException {
        List<Commodity> commodities = null;
        if (null == column || (null != column && "".equalsIgnoreCase(column.trim()))) {
            commodities = DAOFactory.getInstance(CommodityDAOImpl.class).queryAll(currentPage, lineSize);
        } else {
            commodities = DAOFactory.getInstance(CommodityDAOImpl.class).queryAllByColumn(column, keyWord, currentPage, lineSize);
        }
        return commodities;
    }
}
