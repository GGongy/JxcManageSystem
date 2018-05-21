package com.gongy.dao.model;

import java.io.Serializable;

public class TbSellDetail implements Serializable {

    private Integer id;         // 流水号
    private String tbSellMain;  // 销售主表
    private String spid;        // 商品编号
    private Double price;       // 商品单价
    private Integer num;        // 销售数量

    // 空构造函数
    public TbSellDetail() {}

    // 完整构造函数
    public TbSellDetail(String tbSellMain, String spid, Double price, Integer num) {

        this.tbSellMain = tbSellMain;
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

    public String getTbSellMain() {
        return tbSellMain;
    }

    public void setTbSellMain(String tbSellMain) {
        this.tbSellMain = tbSellMain;
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
