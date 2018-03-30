package vo;

import java.io.Serializable;

public class Item implements Serializable {

    private Integer id;
    private Integer contentId;
    private String item;

    public Item() {
    }

    public Item(Integer id, Integer contentId, String item) {
        this.id = id;
        this.contentId = contentId;
        this.item = item;
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
        return "Item{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", item='" + item + '\'' +
                '}';
    }
}
