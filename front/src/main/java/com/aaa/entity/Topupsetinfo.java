package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Topupsetinfo {
    @Id
    @Column
    private Integer tsid;
    @Column
    private Integer tstype;
    @Column
    private String tscustom;
    @Column
    private String tsmoney;

    public Integer getTsid() {
        return tsid;
    }

    public void setTsid(Integer tsid) {
        this.tsid = tsid;
    }

    public Integer getTstype() {
        return tstype;
    }

    public void setTstype(Integer tstype) {
        this.tstype = tstype;
    }

    public String getTscustom() {
        return tscustom;
    }

    public void setTscustom(String tscustom) {
        this.tscustom = tscustom;
    }

    public String getTsmoney() {
        return tsmoney;
    }

    public void setTsmoney(String tsmoney) {
        this.tsmoney = tsmoney;
    }

    @Override
    public String toString() {
        return "Topupsetinfo{" +
                "tsid=" + tsid +
                ", tstype=" + tstype +
                ", tscustom='" + tscustom + '\'' +
                ", tsmoney='" + tsmoney + '\'' +
                '}';
    }
}
