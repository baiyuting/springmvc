package vo;

import java.io.Serializable;

public class Content implements Serializable {

    private Integer id;
    private String content;
    private String img;

    public Content() {
    }

    public Content(Integer id, String content, String img) {
        this.id = id;
        this.content = content;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
