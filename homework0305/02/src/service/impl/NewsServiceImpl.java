package service.impl;

import dao.impl.NewsDAOImpl;
import factory.DAOFactory;
import service.INewsService;
import vo.News;
import vo.User;

import java.sql.SQLException;
import java.util.List;

public class NewsServiceImpl implements INewsService {

    @Override
    public News findById(Integer id) throws SQLException {
        return DAOFactory.getInstance(NewsDAOImpl.class).findById(id);
    }

    @Override
    public boolean add(User user, News vo) throws SQLException {
        boolean temp = false;
        if (user.getGrade() == 0) { // 如果是新闻发布用户
            temp = DAOFactory.getInstance(NewsDAOImpl.class).add(vo) == 1 ? true : false;
        }
        return temp;
    }

    @Override
    public boolean update(User user, News vo) throws SQLException {
        boolean temp = false;
        if (user.getGrade() == 1) { //如果是新闻审核用户
            temp = DAOFactory.getInstance(NewsDAOImpl.class).update(vo) == 1 ? true : false;
        }
        return temp;
    }

    @Override
    public List<News> list(Integer auditStatus, int currentPage, int lineSize) throws SQLException {
        return DAOFactory.getInstance(NewsDAOImpl.class).list(auditStatus, currentPage, lineSize);
    }

    @Override
    public Integer count(Integer auditStatus) throws SQLException {
        return DAOFactory.getInstance(NewsDAOImpl.class).count(auditStatus);
    }
}
