package com.gongy.dao.model;

import java.io.Serializable;

public class TbRkthDetail implements Serializable {

    private Integer id;         // 进货退货编号
    private String tbRkthMain;  // 进货退货主表
    private String spid;        // 商品编号
    private Double price;       // 单价
    private Integer num;        // 数量

    // 空构造函数
    public TbRkthDetail() {}

    // 完整构造函数
    public TbRkthDetail(Integer id, String tbRkthMain, String spid, Double price, Integer num) {

        this.id = id;
        this.tbRkthMain = tbRkthMain;
        this.spid = spid;
        this.price = price;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTbRkthMain() {
        return tbRkthMain;
    }

    public void setTbRkthMain(String tbRkthMain) {
        this.tbRkthMain = tbRkthMain;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
