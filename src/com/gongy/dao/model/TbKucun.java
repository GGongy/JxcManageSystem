package com.gongy.dao.model;

import java.io.Serializable;

public class TbKucun implements Serializable{

    private String id;              // 商品编号
    private String spname;          // 商品名称
    private String jian;            // 商品简称
    private String cd;              // 产地
    private String specification;   // 商品规格
    private String casing;          // 包装
    private String measure;         // 商品计量单位
    private Double price;           // 单价
    private Integer kcnum;          // 库存数量

    // 空构造函数
    public TbKucun() {

    }

    // 最小构造函数（主键）
    public TbKucun(String id) {

    }

    // 完整构造函数
    public TbKucun(String id, String spname, String jian, String cd, String specification, String casing, String measure, Double price, Integer kcnum) {

        this.id = id;
        this.spname = spname;
        this.jian = jian;
        this.cd = cd;
        this.specification = specification;
        this.casing = casing;
        this.measure = measure;
        this.price = price;
        this.kcnum = kcnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getJian() {
        return jian;
    }

    public void setJian(String jian) {
        this.jian = jian;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCasing() {
        return casing;
    }

    public void setCasing(String casing) {
        this.casing = casing;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getKcnum() {
        return kcnum;
    }

    public void setKcnum(Integer kcnum) {
        this.kcnum = kcnum;
    }
}
