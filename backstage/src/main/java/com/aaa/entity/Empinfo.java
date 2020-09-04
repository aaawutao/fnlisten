package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//@Table(name = "empinfo")
public class Empinfo {
    @Id

    private Integer empid;//员工编号

    private String empname;//名字

    private String empphone;//电话

    private String empidentity;//身份证

    private Integer did;//部门

    private String xueli;//学历

   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date empentrydate;//入职
   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date empdimissiondate;//离职
    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }



    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }

    public String getEmpidentity() {
        return empidentity;
    }

    public void setEmpidentity(String empidentity) {
        this.empidentity = empidentity;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public Date getEmpentrydate() {
        return empentrydate;
    }

    public void setEmpentrydate(Date empentrydate) {
        this.empentrydate = empentrydate;
    }

    public Date getEmpdimissiondate() {
        return empdimissiondate;
    }

    public void setEmpdimissiondate(Date empdimissiondate) {
        this.empdimissiondate = empdimissiondate;
    }

    @Override
    public String toString() {
        return "Empinfo{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", empphone='" + empphone + '\'' +
                ", empidentity='" + empidentity + '\'' +
                ", did=" + did +
                ", xueli='" + xueli + '\'' +
                ", empentrydate=" + empentrydate +
                ", empdimissiondate=" + empdimissiondate +
                '}';
    }
}
