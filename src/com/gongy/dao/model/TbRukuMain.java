package com.gongy.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TbRukuMain implements Serializable {

    private String rkId;        // 入库编号
    private String num;         // 品种数量
    private String money;       // 总计金额
    private String ysjl;        // 验收结论
    private String gysname;     // 供应商名称
    private String rkdate;      // 入库时间
    private String czy;         // 操作员
    private String jsr;         // 经手人
    private String jsfs;        // 结算方式
    private Set<TbRukuDetail> tbRukuDetails = new HashSet<TbRukuDetail>(0);

    // 空构造函数
    public TbRukuMain() {}

    // 完整构造函数
    public TbRukuMain(String rkId, String num, String money, String ysjl, String gysname, String rkdate, String czy, String jsr, String jsfs) {

        this.rkId = rkId;
        this.num = num;
        this.money = money;
        this.ysjl = ysjl;
        this.gysname = gysname;
        this.rkdate = rkdate;
        this.czy = czy;
        this.jsr = jsr;
        this.jsfs = jsfs;
    }

    public String getRkId() {
        return rkId;
    }

    public void setRkId(String rkId) {
        this.rkId = rkId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getYsjl() {
        return ysjl;
    }

    public void setYsjl(String ysjl) {
        this.ysjl = ysjl;
    }

    public String getGysname() {
        return gysname;
    }

    public void setGysname(String gysname) {
        this.gysname = gysname;
    }

    public String getRkdate() {
        return rkdate;
    }

    public void setRkdate(String rkdate) {
        this.rkdate = rkdate;
    }

    public String getCzy() {
        return czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    public String getJsr() {
        return jsr;
    }

    public void setJsr(String jsr) {
        this.jsr = jsr;
    }

    public String getJsfs() {
        return jsfs;
    }

    public void setJsfs(String jsfs) {
        this.jsfs = jsfs;
    }

    public Set<TbRukuDetail> getTbRukuDetails() {
        return tbRukuDetails;
    }

    public void setTbRukuDetails(Set<TbRukuDetail> tbRukuDetails) {
        this.tbRukuDetails = tbRukuDetails;
    }
}
