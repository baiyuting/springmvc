package service.impl;

import dao.ICommodityDAO;
import dao.impl.CommodityDAOImpl;
import factory.DAOFactory;
import service.ICommodityService;
import vo.Commodity;

public class CommodityImpl implements ICommodityService {
    @Override
    public boolean add(Commodity commodity) {
        ICommodityDAO commodityDAO = DAOFactory.getInstance(CommodityDAOImpl.class);
        return false;
    }

    @Override
    public boolean update(Commodity commodity) {
        return false;
    }

    @Override
    public boolean delete(Commodity commodity) {
        return false;
    }

    @Override
    public boolean list(String column, String keyWord, int currentPage, int lineSize) {
        return false;
    }
}
