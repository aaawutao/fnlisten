package com.aaa.entity;


import javax.persistence.Table;
import java.util.List;

@Table(name = "menuinfo")
public class Menuinfo  {
    private Integer menuid;
    private String menuname;
    private String menuurl;
    private String menuparentid;

    private List<Menuinfo> ziList;

    public List<Menuinfo> getZiList() {
        return ziList;
    }

    public void setZiList(List<Menuinfo> ziList) {
        this.ziList = ziList;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public String getMenuparentid() {
        return menuparentid;
    }

    public void setMenuparentid(String menuparentid) {
        this.menuparentid = menuparentid;
    }

    @Override
    public String toString() {
        return "Menuinfo{" +
                "menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", menuparentid='" + menuparentid + '\'' +
                ", ziList=" + ziList +
                '}';
    }
}
