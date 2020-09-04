package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import java.util.Date;

public class Chapterinfo {

    @Id
    private Integer ctid;

    private String title;
    private String artist;
    private String mp3;
    private Integer state;
    private  Integer virtualcurrency;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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


    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVirtualcurrency() {
        return virtualcurrency;
    }

    public void setVirtualcurrency(Integer virtualcurrency) {
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
