package com.aaa.entity;

import javax.persistence.Id;
import java.util.Date;

public class Chapterinfo {

    @Id
    private Integer ctid;

    private String title;
    private String artist;
    private String mp3;
    private Integer state;
    private String virtualcurrency;
    private Date createdate;
    private Integer pid;

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSrc() {
        return mp3;
    }

    public void setSrc(String mp3) {
        this.mp3 = mp3;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getVirtualcurrency() {
        return virtualcurrency;
    }

    public void setVirtualcurrency(String virtualcurrency) {
        this.virtualcurrency = virtualcurrency;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Chapterinfo{" +
                "ctid=" + ctid +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", mp3='" + mp3 + '\'' +
                ", state=" + state +
                ", virtualcurrency='" + virtualcurrency + '\'' +
                ", createdate=" + createdate +
                ", pid=" + pid +
                '}';
    }
}
