package service.impl;

import dao.impl.ContentDAOImpl;
import dao.impl.ItemDAOImpl;
import dao.impl.VoteDAOImpl;
import dto.ItemDTO;
import dto.VoteInfoDTO;
import factory.DAOFactory;
import service.IVoteService;
import vo.Content;
import vo.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteServiceImpl implements IVoteService {
    @Override
    public List<VoteInfoDTO> list(Integer userId, Integer pageNo, Integer pageSize) throws SQLException {
        List<VoteInfoDTO> list = new ArrayList<>();
        List<Content> contents = DAOFactory.getInstance(ContentDAOImpl.class).list(pageNo, pageSize);
        for (Content content : contents) {
            List<ItemDTO> itemDTOS = new ArrayList<>();
            List<Item> items = DAOFactory.getInstance(ItemDAOImpl.class).findByContentId(content.getId());
            for (Item item : items)
                itemDTOS.add(new ItemDTO(item, DAOFactory.getInstance(VoteDAOImpl.class).findByUserIdAndItemId(userId, item.getId())));
            list.add(new VoteInfoDTO(content, itemDTOS));
        }
        return list;
    }

    @Override
    public Integer count() throws SQLException {
        return DAOFactory.getInstance(ContentDAOImpl.class).count();
    }
}
