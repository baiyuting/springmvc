package vo;

import java.io.Serializable;

public class Menu implements Serializable {

   private int mid;
   private String title;
   private int pid;

    public Menu(int mid, String title, int pid) {
        this.mid = mid;
        this.title = title;
        this.pid = pid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

}
