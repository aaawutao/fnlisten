package com.aaa.entity;

import javax.persistence.Id;

public class Collection {
    @Id
    private Integer cid;
    private Integer  front_userid;
    private Integer pid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getFront_userid() {
        return front_userid;
    }

    public void setFront_userid(Integer front_userid) {
        this.front_userid = front_userid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "cid=" + cid +
                ", front_userid=" + front_userid +
                ", pid=" + pid +
                '}';
    }
}
