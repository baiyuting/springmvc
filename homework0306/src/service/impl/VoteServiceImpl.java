package service.impl;

import dao.IContentDAO;
import dao.IItemDAO;
import dao.IVoteDAO;
import dao.impl.ContentDAOImpl;
import dao.impl.ItemDAOImpl;
import dao.impl.VoteDAOImpl;
import dto.ItemDTO;
import dto.VoteInfoDTO;
import factory.DAOFactory;
import service.IVoteService;
import vo.Content;
import vo.Item;
import vo.Vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
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

    @Override
    public void addVoteInfo(String img, String content, String items) throws IOException, SQLException {
        IContentDAO contentDAO = DAOFactory.getInstance(ContentDAOImpl.class);
        contentDAO.add(new Content(content, img));
        Content temp = contentDAO.findByImg(img);
        IItemDAO iItemDAO = DAOFactory.getInstance(ItemDAOImpl.class);
        BufferedReader reader = new BufferedReader(new StringReader(items));
        String item = null;
        while ((item = reader.readLine()) != null)
            iItemDAO.add(new Item(temp.getId(), item));
        reader.close();
    }

    @Override
    public Integer addVotedItem(Integer userId, Integer itemId) throws SQLException {
        Integer res = 0;
        if (null != userId && null != itemId) {
            IVoteDAO voteDAO = DAOFactory.getInstance(VoteDAOImpl.class);
            Vote vote = voteDAO.findByUserIdAndItemId(userId, itemId);
            if (null == vote) {
                vote = new Vote(userId, itemId);
                res = voteDAO.add(vote);
            }
        }
        return res;
    }
}
