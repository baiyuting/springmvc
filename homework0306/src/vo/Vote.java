package vo;

import java.io.Serializable;

public class Vote implements Serializable {

    private Integer id;
    private Integer userId;
    private Integer itemId;

    public Vote() {
    }

    public Vote(Integer userId, Integer itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    public Vote(Integer id, Integer userId, Integer itemId) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                '}';
    }
}
