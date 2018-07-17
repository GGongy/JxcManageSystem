package com.gongy.dao;

public class Columns {

    private String name;            // 列名
    private String type;            // 字段类型
    private boolean isNull;         // 是否可以为空
    private boolean isKey;          // 是否是主键
    private boolean isIncerment;    // 是否自增

    public Columns() {
        super();
    }

    public Columns(String name, String type, boolean isNull, boolean isKey, boolean isIncerment) {
        super();

        this.name = name;
        this.type = type;
        this.isNull = isNull;
        this.isKey = isKey;
        this.isIncerment = isIncerment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public boolean isIncerment() {
        return isIncerment;
    }

    public void setIncerment(boolean incerment) {
        isIncerment = incerment;
    }

    @Override
    public String toString() {
        return "Columns{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isNull=" + isNull +
                ", isKey=" + isKey +
                ", isIncerment=" + isIncerment +
                '}';
    }
}
