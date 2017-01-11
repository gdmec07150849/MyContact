package com.gdmec.jacky.mycontacts;

public class User {
    public final static String NANE="name";
    public final static String TEL="tel";
    public final static String UNIT="unit";
    public final static String QQ="qq";
    public final static String ADDRESS="address";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_DB() {
        return id_DB;
    }

    public void setId_DB(int id_DB) {
        this.id_DB = id_DB;
    }

    private String name;
    private String tel;
    private String unit;
    private String qq;
    private String address;
    private int id_DB=-1;
}
