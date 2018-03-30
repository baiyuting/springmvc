package dto;

import vo.Item;
import vo.Vote;

public class ItemDTO {


    private Integer id;
    private Integer contentId;
    private String item;

    private Integer voted;//表示是否已经被 用户投过票了

    public ItemDTO(Integer id, Integer contentId, String item, Vote vote) {
        this.id = id;
        this.contentId = contentId;
        this.item = item;
        this.voted = null == vote ? 0 : 1;
    }

    public ItemDTO(Item item, Vote vote) {
        this(item.getId(), item.getContentId(), item.getItem(), vote);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", item='" + item + '\'' +
                ", voted=" + voted +
                '}';
    }
}
