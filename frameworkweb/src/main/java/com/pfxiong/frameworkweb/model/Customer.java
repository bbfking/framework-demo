package com.pfxiong.frameworkweb.model;

import java.io.Serializable;

/**
 * Created by pfXiong on 2015/11/17.
 * 客户实体
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 2807573308243484482L;
    private long id;
    private String name;
    private String contact;
    private String telephone;
    private String email;
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
