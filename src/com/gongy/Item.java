package com.gongy;

// 数据表公共类
public class Item {

    private String id;      // 编号属性
    private String name;    // 名称信息

    public Item() {         // 缺省构造函数
    }

    public Item(String id, String name) {       // 完整构造函数
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return getName();
    }
}
