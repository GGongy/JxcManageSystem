package com.gongy.dao.model;

import java.io.Serializable;

public class TbGysinfo implements Serializable{

    private String id;      // 供应商编号
    private String name;    // 供应商名称
    private String jc;      // 供应商简称
    private String address; // 供应商地址
    private String code;    // 邮政编码
    private String tel;     // 电话
    private String fax;     // 传真
    private String linkman; // 联系人
    private String phone;   // 联系电话
    private String bank;    // 开户行
    private String mail;    // 电子邮箱

    // 空构造函数
    public TbGysinfo() {
    }

    // 最小构造函数（主键）
    public TbGysinfo(String id) {
        this.id = id;
    }

    // 完整构造函数
    public TbGysinfo(String id, String name, String jc, String address, String code, String tel, String fax, String linkman, String phone, String bank, String mail) {
        this.id = id;
        this.name = name;
        this.jc = jc;
        this.address = address;
        this.code = code;
        this.tel = tel;
        this.fax = fax;
        this.linkman = linkman;
        this.phone = phone;
        this.bank = bank;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
