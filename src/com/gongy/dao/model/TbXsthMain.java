package com.gongy.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TbXsthMain implements Serializable{

    private String xsthId;      // 销售退货编号
    private String num;         // 品种数量
    private String money;       // 总计金额
    private String ysjl;        // 验收结论
    private String khname;      // 客户名称
    private String thdate;      // 退货日期
    private String czy;         // 操作员
    private String jsr;         // 经手人
    private String jsfs;        // 结算方式
    private Set tbXsthDateild = new HashSet(0);     // 销售退货详细信息

    // 空构造函数
    public TbXsthMain() {}

    // 完整构造函数
    public TbXsthMain(String xsthId, String num, String money, String ysjl, String khname, String thdate, String czy, String jsr, String jsfs) {

        this.xsthId = xsthId;
        this.num = num;
        this.money = money;
        this.ysjl = ysjl;
        this.khname = khname;
        this.thdate = thdate;
        this.czy = czy;
        this.jsr = jsr;
        this.jsfs = jsfs;
    }

    public String getXsthId() {
        return xsthId;
    }

    public void setXsthId(String xsthId) {
        this.xsthId = xsthId;
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

    public String getThdate() {
        return thdate;
    }

    public void setThdate(String thdate) {
        this.thdate = thdate;
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

    public Set getTbXsthDateild() {
        return tbXsthDateild;
    }

    public void setTbXsthDateild(Set tbXsthDateild) {
        this.tbXsthDateild = tbXsthDateild;
    }
}
