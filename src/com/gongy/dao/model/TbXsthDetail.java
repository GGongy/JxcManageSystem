package com.gongy.dao.model;

import java.io.Serializable;

public class TbXsthDetail implements Serializable{

    private Integer id;         // 销售退货编号
    private String tbXsthMain;  // 销售退货主表
    private String spid;        // 商品编号
    private Double price;       // 单价
    private Integer num;        // 数量

    // 空构造函数
    public TbXsthDetail() {}

    // 完整构造函数
    public TbXsthDetail(String tbXsthMain, String spid, Double price, Integer num) {
        this.tbXsthMain = tbXsthMain;
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

    public String getTbXsthMain() {
        return tbXsthMain;
    }

    public void setTbXsthMain(String tbXsthMain) {
        this.tbXsthMain = tbXsthMain;
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
