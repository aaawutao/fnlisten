package com.aaa.entity;

import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

public class Anchorinfo {
    @Id
    private Integer acid;
    private Integer actype;
    private Integer bfid;
    private String petname;

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public Integer getActype() {
        return actype;
    }

    public void setActype(Integer actype) {
        this.actype = actype;
    }

    public Integer getBfid() {
        return bfid;
    }

    public void setBfid(Integer bfid) {
        this.bfid = bfid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    @Override
    public String toString() {
        return "Anchorinfo{" +
                "acid=" + acid +
                ", actype=" + actype +
                ", bfid=" + bfid +
                ", petname='" + petname + '\'' +
                '}';
    }
}
