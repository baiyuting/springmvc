package vo;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {

    private Integer id;
    private String title;
    private Date publishTime;
    private String keyword;
    private String content;
    private Integer auditStatus;
    private Date auditDate;
    private Integer auditUserId;
    private String auditFailReason;

    public News() {
    }

    public News(Integer id, String title, Date publishTime, String keyword, String content, Integer auditStatus, Date auditDate, Integer auditUserId, String auditFailReason) {
        this.id = id;
        this.title = title;
        this.publishTime = publishTime;
        this.keyword = keyword;
        this.content = content;
        this.auditStatus = auditStatus;
        this.auditDate = auditDate;
        this.auditUserId = auditUserId;
        this.auditFailReason = auditFailReason;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishTime=" + publishTime +
                ", keyword='" + keyword + '\'' +
                ", content='" + content + '\'' +
                ", auditStatus=" + auditStatus +
                ", auditDate=" + auditDate +
                ", auditUserId=" + auditUserId +
                ", auditFailReason='" + auditFailReason + '\'' +
                '}';
    }
}
