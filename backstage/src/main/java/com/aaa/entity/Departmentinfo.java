package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Departmentinfo")
public class Departmentinfo {
    @Id
    private Integer did;
    @Column
    private String dname;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Departmentinfo(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Departmentinfo{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
