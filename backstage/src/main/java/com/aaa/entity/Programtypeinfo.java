package com.aaa.entity;

import javax.persistence.Id;

public class Programtypeinfo {

    @Id
    private Integer ptid;

    private String ptname;

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }

    @Override
    public String toString() {
        return "Programtypeinfo{" +
                "ptid=" + ptid +
                ", ptname='" + ptname + '\'' +
                '}';
    }
}
