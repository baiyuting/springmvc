package dto;

import vo.News;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDTO implements Serializable {

    private Integer id;
    private String title;
    private Date publishTime;
    private String summary;
    private String content;
    private String imgs;
    private Integer auditStatus;
    private Date auditDate;
    private Integer auditUserId;
    private String auditFailReason;
    private List<String> imgList = new ArrayList<>();

    public NewsDTO() {
    }

    public NewsDTO(Integer id, String title, Date publishTime, String summary, String content, String imgs, Integer auditStatus, Date auditDate, Integer auditUserId, String auditFailReason) {
        this.id = id;
        this.title = title;
        this.publishTime = publishTime;
        this.summary = summary;
        this.content = content;
        this.imgs = imgs;
        this.auditStatus = auditStatus;
        this.auditDate = auditDate;
        this.auditUserId = auditUserId;
        this.auditFailReason = auditFailReason;
        if (null != imgs && !imgs.trim().equals("")){
            String[] imgArr = imgs.split(",");
            for (String img:imgArr)
                imgList.add(img);
        }
    }

    public NewsDTO(News news){
        this.id = news.getId();
        this.title = news.getTitle();
        this.publishTime = news.getPublishTime();
        this.summary = news.getSummary();
        this.content = news.getContent();
        this.imgs = news.getImgs();
        this.auditStatus = news.getAuditStatus();
        this.auditDate = news.getAuditDate();
        this.auditUserId = news.getAuditUserId();
        this.auditFailReason = news.getAuditFailReason();
        if (null != imgs && !imgs.trim().equals("")){
            String[] imgArr = imgs.split(",");
            for (String img:imgArr)
                imgList.add(img);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditFailReason() {
        return auditFailReason;
    }

    public void setAuditFailReason(String auditFailReason) {
        this.auditFailReason = auditFailReason;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
