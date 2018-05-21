package com.gongy.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TbSellMain implements Serializable {

    private String sellId;      // 销售编号
    private String num;         // 销售品种数
    private String money;       // 金额
    private String ysjl;        // 验收结论
    private String khname;      // 客户名称
    private String xsdate;      // 销售日期
    private String czy;         // 操作员
    private String jsr;         // 经手人
    private String jsfs;        // 结算方式
    private Set tbSellDetails = new HashSet(0);     // 销售明细

    // 空构造函数
    public TbSellMain(){}

    // 完整构造函数
    public TbSellMain(String sellId, String num, String money, String ysjl, String khname, String xsdate, String czy, String jsr, String jsfs) {

        this.sellId = sellId;
        this.num = num;
        this.money = money;
        this.ysjl = ysjl;
        this.khname = khname;
        this.xsdate = xsdate;
        this.czy = czy;
        this.jsr = jsr;
        this.jsfs = jsfs;
    }

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
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

    public String getKhname() {
        return khname;
    }

    public void setKhname(String khname) {
        this.khname = khname;
    }

    public String getXsdate() {
        return xsdate;
    }

    public void setXsdate(String xsdate) {
        this.xsdate = xsdate;
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

    public Set getTbSellDetails() {
        return tbSellDetails;
    }

    public void setTbSellDetails(Set tbSellDetails) {
        this.tbSellDetails = tbSellDetails;
    }
}
