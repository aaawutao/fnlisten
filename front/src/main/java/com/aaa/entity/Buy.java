package com.aaa.entity;

import javax.persistence.Id;
import java.util.Date;

public class Buy {
    @Id
    public Integer bpid;
    public Integer purchaser;
    public Integer pid;
    public Integer ctid;
    public Integer purchaservc;
    public Double purchasermoney;
    public Double acquiree_original_money;
    public Double acquireeparticipation;
    public Double acquiree_now_money;
    public Date buydate;

    public Integer getBpid() {
        return bpid;
    }

    public void setBpid(Integer bpid) {
        this.bpid = bpid;
    }

    public Integer getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Integer purchaser) {
        this.purchaser = purchaser;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Integer getPurchaservc() {
        return purchaservc;
    }

    public void setPurchaservc(Integer purchaservc) {
        this.purchaservc = purchaservc;
    }

    public Double getPurchasermoney() {
        return purchasermoney;
    }

    public void setPurchasermoney(Double purchasermoney) {
        this.purchasermoney = purchasermoney;
    }

    public Double getAcquiree_original_money() {
        return acquiree_original_money;
    }

    public void setAcquiree_original_money(Double acquiree_original_money) {
        this.acquiree_original_money = acquiree_original_money;
    }

    public Double getAcquireeparticipation() {
        return acquireeparticipation;
    }

    public void setAcquireeparticipation(Double acquireeparticipation) {
        this.acquireeparticipation = acquireeparticipation;
    }

    public Double getAcquiree_now_money() {
        return acquiree_now_money;
    }

    public void setAcquiree_now_money(Double acquiree_now_money) {
        this.acquiree_now_money = acquiree_now_money;
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "bpid=" + bpid +
                ", purchaser=" + purchaser +
                ", pid=" + pid +
                ", ctid=" + ctid +
                ", purchaservc=" + purchaservc +
                ", purchasermoney=" + purchasermoney +
                ", acquiree_original_money=" + acquiree_original_money +
                ", acquireeparticipation=" + acquireeparticipation +
                ", acquiree_now_money=" + acquiree_now_money +
                ", buydate=" + buydate +
                '}';
    }
}
