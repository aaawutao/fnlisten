package com.aaa.entity;

import javax.persistence.Id;
import java.util.Date;

public class Topupinfo {
    @Id
    private String tpid;
    private Integer front_userid;
    private Date topupdate;
    private Integer tsid;
    private String topupway;
    private Integer state;
    private Double tsr;
    private String paymentid;


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTpid() {
        return tpid;
    }

    public void setTpid(String tpid) {
        this.tpid = tpid;
    }

    public Integer getFront_userid() {
        return front_userid;
    }

    public void setFront_userid(Integer front_userid) {
        this.front_userid = front_userid;
    }

    public Date getTopupdate() {
        return topupdate;
    }

    public void setTopupdate(Date topupdate) {
        this.topupdate = topupdate;
    }

    public Integer getTsid() {
        return tsid;
    }

    public void setTsid(Integer tsid) {
        this.tsid = tsid;
    }

    public String getTopupway() {
        return topupway;
    }

    public void setTopupway(String topupway) {
        this.topupway = topupway;
    }

    public Double getTsr() {
        return tsr;
    }

    public void setTsr(Double tsr) {
        this.tsr = tsr;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    @Override
    public String toString() {
        return "Topupinfo{" +
                "tpid='" + tpid + '\'' +
                ", front_userid=" + front_userid +
                ", topupdate=" + topupdate +
                ", tsid=" + tsid +
                ", topupway='" + topupway + '\'' +
                ", tsr=" + tsr +
                ", paymentid='" + paymentid + '\'' +
                ", state=" + state +
                '}';
    }
}
