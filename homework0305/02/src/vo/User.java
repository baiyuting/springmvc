package vo;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String password;

    /**
     * 用户级别有两个：
     * <p>
     * |- 级别 = 0：新闻发布用户；
     * <p>
     * |- 级别 = 1：新闻审核用户；
     */
    private Integer grade;

    public User() {
    }

    public User(Integer id, String password, Integer grade) {
        this.id = id;
        this.password = password;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }
}
