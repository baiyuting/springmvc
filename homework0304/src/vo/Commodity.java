package vo;

import java.io.Serializable;

public class Commodity implements Serializable {

    private Integer id;
    private String name;
    private Double price;

    /**
     * 商品状态 = 0：表示该商品刚信息刚刚发布，但是还未提交审核，用户可以修改商品信息；
     * <p>
     * 商品状态 = 1：表示该商品信息等待审核，审核期间不允许修改商品信息；
     * <p>
     * 商品状态 = 2：表示该商品信息已经通过审核，审核通过后不允许修改商品价格，但是允许修改商品名称；
     * <p>
     * 商品状态 = 3：表示该商品信息未通过审核，用户可以修改商品任何信息；
     * <p>
     * 商品状态 = 4：表示该商品已经被删除掉，即：无法搜索到商品信息。
     */
    private Integer flag;

    public Commodity() {
    }

    public Commodity(Integer id, String name, Double price, Integer flag) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
