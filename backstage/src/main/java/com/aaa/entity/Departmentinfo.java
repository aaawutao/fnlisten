package com.aaa.entity;


import javax.persistence.Id;

public class Departmentinfo {
    @Id
    private Integer did;
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
