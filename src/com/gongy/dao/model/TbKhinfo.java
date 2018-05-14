package com.gongy.dao.model;

import java.io.Serializable;

public class TbKhinfo implements Serializable {

    private String id;          // 客户编号
    private String khname;      // 客户名称
    private String jian;        // 客户简称
    private String address;     // 客户地址
    private String postcode;    // 邮编
    private String phone;       // 电话
    private String fax;         // 传真
    private String lian;        // 联系人
    private String tel;         // 联系电话
    private String mail;        // 电子邮箱
    private String bank;        // 开户银行
    private String num;         // 银行账户

    // 空构造函数
    public TbKhinfo() {

    }

    // 最小构造函数（主键）
    public TbKhinfo(String id) {

    }

    public TbKhinfo(String id, String khname, String jian, String address, String postcode, String fax, String lian, String tel, String mail, String bank, String num) {
        this.id = id;
        this.khname = khname;
        this.jian = jian;
        this.address = address;
        this.postcode = postcode;
        this.fax = fax;
        this.lian = lian;
        this.tel = tel;
        this.mail = mail;
        this.bank = bank;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKhname() {
        return khname;
    }

    public void setKhname(String khname) {
        this.khname = khname;
    }

    public String getJian() {
        return jian;
    }

    public void setJian(String jian) {
        this.jian = jian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLian() {
        return lian;
    }

    public void setLian(String lian) {
        this.lian = lian;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
