package com.gongy.dao.model;

import java.io.Serializable;

public class TbRukuDetail implements Serializable {

    private String id;          // 流水号
    private String tbSpinfo;    // 商品信息
    private String tbRukuMain;  // 入库主表
    private Double price;       // 单价
    private Integer num;        // 数量

    // 空构造函数
    public TbRukuDetail(){}

    // 完整构造函数
    public TbRukuDetail(String id, String tbSpinfo, String tbRukuMain, Double price, Integer num){

        this.id = id;
        this.tbSpinfo = tbSpinfo;
        this.tbRukuMain = tbRukuMain;
        this.price = price;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTbSpinfo() {
        return tbSpinfo;
    }

    public void setTbSpinfo(String tbSpinfo) {
        this.tbSpinfo = tbSpinfo;
    }

    public String getTbRukuMain() {
        return tbRukuMain;
    }

    public void setTbRukuMain(String tbRukuMain) {
        this.tbRukuMain = tbRukuMain;
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
