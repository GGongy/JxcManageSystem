package com.gongy.dao.model;

import java.io.Serializable;

public class TbJsr implements Serializable {

    private String name;        // 经手人姓名
    private String sex;         // 经手人性别
    private String age;         // 经手人年龄
    private String tel;         // 经手人电话

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
