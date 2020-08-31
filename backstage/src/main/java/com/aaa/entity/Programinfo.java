package com.aaa.entity;

import javax.persistence.Id;
import java.util.Date;

public class Programinfo {

    @Id
    private Integer pid;
    private String pname;
    private String poster;
    private String pintroduction;
    private Integer ptid;
    private String psource;
    private Integer anchortid;
    private Integer chapterorder;
    private Date pcreatedate;
    private Integer buycount;
    private Integer pstate;
    private Double allprice;
    private Integer pstatus;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPintroduction() {
        return pintroduction;
    }

    public void setPintroduction(String pintroduction) {
        this.pintroduction = pintroduction;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getPsource() {
        return psource;
    }

    public void setPsource(String psource) {
        this.psource = psource;
    }

    public Integer getAnchortid() {
        return anchortid;
    }

    public void setAnchortid(Integer anchortid) {
        this.anchortid = anchortid;
    }

    public Integer getChapterorder() {
        return chapterorder;
    }

    public void setChapterorder(Integer chapterorder) {
        this.chapterorder = chapterorder;
    }

    public Date getPcreatedate() {
        return pcreatedate;
    }

    public void setPcreatedate(Date pcreatedate) {
        this.pcreatedate = pcreatedate;
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
    }

    public Integer getPstate() {
        return pstate;
    }

    public void setPstate(Integer pstate) {
        this.pstate = pstate;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }

    @Override
    public String toString() {
        return "Programinfo{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", poster='" + poster + '\'' +
                ", pintroduction='" + pintroduction + '\'' +
                ", ptid=" + ptid +
                ", psource='" + psource + '\'' +
                ", anchortid=" + anchortid +
                ", chapterorder=" + chapterorder +
                ", pcreatedate=" + pcreatedate +
                ", buycount=" + buycount +
                ", pstate=" + pstate +
                ", allprice=" + allprice +
                ", pstatus=" + pstatus +
                '}';
    }
}
