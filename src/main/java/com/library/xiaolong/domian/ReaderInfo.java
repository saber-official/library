package com.library.xiaolong.domian;

import java.io.Serializable;
import java.util.Date;

public class ReaderInfo implements Serializable {

    private Long reader_id;
    private String name;
    private String sex;
    private Date birth;
    private String address;
    private String phone;

    public ReaderInfo(String name, String sex, Date birth, String address, String phone) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
    }

    public ReaderInfo() {
    }

    public Long getReaderId() {
        return reader_id;
    }

    public void setReaderId(Long reader_id) {
        this.reader_id = reader_id;
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ReaderInfo{" +
                "reader_id=" + reader_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
