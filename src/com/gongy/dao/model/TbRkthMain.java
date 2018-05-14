package com.gongy.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TbRkthMain implements Serializable {

    private String rkthId;      // 进货退货编号
    private String pzd;         // 销售品种数
    private String sum;         // 总计金额
    private String ysjl;        // 验收结论
    private String gysname;     // 供应商名称
    private String rkdate;      // 进货退货时间
    private String czy;         // 操作员
    private String jsr;         // 经手人
    private String jsfs;        // 结算方式
    private Set tbRkthDetails = new HashSet(0); // 进货退货详细信息

    // 空构造函数
    public TbRkthMain(){}

    // 完整构造函数
    public TbRkthMain(String rkthId, String pzd, String sum, String ysjl, String gysname, String rkdate, String czy, String jsr, String jsfs) {

        this.rkthId = rkthId;
        this.pzd = pzd;
        this.sum = sum;
        this.ysjl = ysjl;
        this.gysname = gysname;
        this.rkdate = rkdate;
        this.czy = czy;
        this.jsr = jsr;
        this.jsfs = jsfs;
    }

    public String getRkthId() {
        return rkthId;
    }

    public void setRkthId(String rkthId) {
        this.rkthId = rkthId;
    }

    public String getPzd() {
        return pzd;
    }

    public void setPzd(String pzd) {
        this.pzd = pzd;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
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

    public Set getTbRkthDetails() {
        return tbRkthDetails;
    }

    public void setTbRkthDetails(Set tbRkthDetails) {
        this.tbRkthDetails = tbRkthDetails;
    }
}
