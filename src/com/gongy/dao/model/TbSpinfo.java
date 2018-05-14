package com.gongy.dao.model;

// 商品信息（实现序列化借口）
public class TbSpinfo implements java.io.Serializable {

    private String id;          // 商品编号
    private String spname;      // 商品名称
    private String jc;          // 商品简称
    private String cd;          // 产地
    private String dw;          // 商品计量单位
    private String gg;          // 商品规格
    private String bz;          // 包装
    private String ph;          // 批号
    private String pzwh;        // 批准文号
    private String memo;        // 备注
    private String gysname;     // 供应商名称

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

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getGysname() {
        return gysname;
    }

    public void setGysname(String gysname) {
        this.gysname = gysname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbSpinfo tbSpinfo = (TbSpinfo) o;

        if (!id.equals(tbSpinfo.id)) return false;
        if (!spname.equals(tbSpinfo.spname)) return false;
        if (!jc.equals(tbSpinfo.jc)) return false;
        if (!cd.equals(tbSpinfo.cd)) return false;
        if (!dw.equals(tbSpinfo.dw)) return false;
        if (!gg.equals(tbSpinfo.gg)) return false;
        if (!bz.equals(tbSpinfo.bz)) return false;
        if (!ph.equals(tbSpinfo.ph)) return false;
        if (!pzwh.equals(tbSpinfo.pzwh)) return false;
        if (!memo.equals(tbSpinfo.memo)) return false;
        return gysname.equals(tbSpinfo.gysname);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + spname.hashCode();
        result = 31 * result + jc.hashCode();
        result = 31 * result + cd.hashCode();
        result = 31 * result + dw.hashCode();
        result = 31 * result + gg.hashCode();
        result = 31 * result + bz.hashCode();
        result = 31 * result + ph.hashCode();
        result = 31 * result + pzwh.hashCode();
        result = 31 * result + memo.hashCode();
        result = 31 * result + gysname.hashCode();
        return result;
    }
}
