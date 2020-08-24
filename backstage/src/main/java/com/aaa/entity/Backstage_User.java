package com.aaa.entity;

import javax.persistence.Table;

@Table(name="backstage_user")
public class Backstage_User {

    private Integer backstage_userid; //账号编号

    private String backstage_uname;//账号用户名

    private String  backstage_upwd;//账号密码

    private Integer  backstage_userstate;//是否可用(0.可用 1.不可用)

    private Integer empid;//员工编号

    private Integer backstage_type;//账号类型(管理0,主播1,默认生成主播信息)

    private String  backstage_js;//介绍

    private String  backstage_photo;//头像

    public Integer getBackstage_userid() {
        return backstage_userid;
    }

    public void setBackstage_userid(Integer backstage_userid) {
        this.backstage_userid = backstage_userid;
    }

    public String getBackstage_uname() {
        return backstage_uname;
    }

    public void setBackstage_uname(String backstage_uname) {
        this.backstage_uname = backstage_uname;
    }

    public String getBackstage_upwd() {
        return backstage_upwd;
    }

    public void setBackstage_upwd(String backstage_upwd) {
        this.backstage_upwd = backstage_upwd;
    }

    public Integer getBackstage_userstate() {
        return backstage_userstate;
    }

    public void setBackstage_userstate(Integer backstage_userstate) {
        this.backstage_userstate = backstage_userstate;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getBackstage_type() {
        return backstage_type;
    }

    public void setBackstage_type(Integer backstage_type) {
        this.backstage_type = backstage_type;
    }

    public String getBackstage_js() {
        return backstage_js;
    }

    public void setBackstage_js(String backstage_js) {
        this.backstage_js = backstage_js;
    }

    public String getBackstage_photo() {
        return backstage_photo;
    }

    public void setBackstage_photo(String backstage_photo) {
        this.backstage_photo = backstage_photo;
    }

    @Override
    public String toString() {
        return "Backstage_User{" +
                "backstage_userid=" + backstage_userid +
                ", backstage_uname='" + backstage_uname + '\'' +
                ", backstage_upwd='" + backstage_upwd + '\'' +
                ", backstage_userstate=" + backstage_userstate +
                ", empid=" + empid +
                ", backstage_type=" + backstage_type +
                ", backstage_js='" + backstage_js + '\'' +
                ", backstage_photo='" + backstage_photo + '\'' +
                '}';
    }
}
