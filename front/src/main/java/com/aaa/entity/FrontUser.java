package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "front_user")
public class FrontUser {

    @Id
    private Integer front_userid;
    private String front_username;
    private String front_userpic;
    private String front_userphone;
    private String front_userpwd;
    private Integer front_userstate;//用户状态 0.正常 1.禁用.2 vip
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /* @DateTimeFormat(pattern = "yyyy-mm-dd")*/
    private Date front_usercreatedate;//用户创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date front_uservipoutdata;//用户vip过期时间(可以null),创建定时任务(如果当前时间大于过期时间,修改状态)
    private Integer front_userflag;//角色标识1.听客 2.个人主播,3机构
    private Integer flag;
    private String front_userqqflag;//qq登录信息标识
    private Integer front_usermoney;//用户虚拟币(默认0)
    private Double front_userwd; //用户提现金额

    public Integer getFront_userid() {
        return front_userid;
    }

    public void setFront_userid(Integer front_userid) {
        this.front_userid = front_userid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getFront_username() {
        return front_username;
    }

    public void setFront_username(String front_username) {
        this.front_username = front_username;
    }

    public String getFront_userpic() {
        return front_userpic;
    }

    public void setFront_userpic(String front_userpic) {
        this.front_userpic = front_userpic;
    }

    public String getFront_userphone() {
        return front_userphone;
    }

    public void setFront_userphone(String front_userphone) {
        this.front_userphone = front_userphone;
    }

    public String getFront_userpwd() {
        return front_userpwd;
    }

    public void setFront_userpwd(String front_userpwd) {
        this.front_userpwd = front_userpwd;
    }

    public Integer getFront_userstate() {
        return front_userstate;
    }

    public void setFront_userstate(Integer front_userstate) {
        this.front_userstate = front_userstate;
    }

    public Date getFront_usercreatedate() {
        return front_usercreatedate;
    }

    public void setFront_usercreatedate(Date front_usercreatedate) {
        this.front_usercreatedate = front_usercreatedate;
    }

    public Date getFront_uservipoutdata() {
        return front_uservipoutdata;
    }

    public void setFront_uservipoutdata(Date front_uservipoutdata) {
        this.front_uservipoutdata = front_uservipoutdata;
    }

    public Integer getFront_userflag() {
        return front_userflag;
    }

    public void setFront_userflag(Integer front_userflag) {
        this.front_userflag = front_userflag;
    }

    public String getFront_userqqflag() {
        return front_userqqflag;
    }

    public void setFront_userqqflag(String front_userqqflag) {
        this.front_userqqflag = front_userqqflag;
    }

    public Integer getFront_usermoney() {
        return front_usermoney;
    }

    public void setFront_usermoney(Integer front_usermoney) {
        this.front_usermoney = front_usermoney;
    }

    public Double getFront_userwd() {
        return front_userwd;
    }

    public void setFront_userwd(Double front_userwd) {
        this.front_userwd = front_userwd;
    }

    @Override
    public String toString() {
        return "FrontUser{" +
                "front_userid=" + front_userid +
                ", front_username='" + front_username + '\'' +
                ", front_userpic='" + front_userpic + '\'' +
                ", front_userphone='" + front_userphone + '\'' +
                ", front_userpwd='" + front_userpwd + '\'' +
                ", front_userstate=" + front_userstate +
                ", front_usercreatedate=" + front_usercreatedate +
                ", front_uservipoutdata=" + front_uservipoutdata +
                ", front_userflag=" + front_userflag +
                ", flag=" + flag +
                ", front_userqqflag='" + front_userqqflag + '\'' +
                ", front_usermoney='" + front_usermoney + '\'' +
                ", front_userwd=" + front_userwd +
                '}';
    }
}
