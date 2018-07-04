package dto;

import vo.Content;

import java.io.Serializable;
import java.util.List;

public class VoteInfoDTO {
    private Content content;
    private List<ItemDTO> itemDTOS;

    public VoteInfoDTO(Content content, List<ItemDTO> itemDTOS) {
        this.content = content;
        this.itemDTOS = itemDTOS;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<ItemDTO> getItemDTOS() {
        return itemDTOS;
    }

    public void setItemDTOS(List<ItemDTO> itemDTOS) {
        this.itemDTOS = itemDTOS;
    }

    @Override
    public String toString() {
        return "VoteInfoDTO{" +
                "content=" + content +
                ", itemDTOS=" + itemDTOS +
                '}';
    }
}
