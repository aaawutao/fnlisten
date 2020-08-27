package com.aaa.entity;


import javax.persistence.Table;
import java.util.List;

@Table(name = "menuinfo")
public class Menuinfo  {
    private Integer id;
    private String menuname;
    private String menuurl;
    private String parentId;

    private List<Menuinfo> ziList;

    public List<Menuinfo> getZiList() {
        return ziList;
    }

    public void setZiList(List<Menuinfo> ziList) {
        this.ziList = ziList;
    }

    public Integer getMenuid() {
        return id;
    }

    public void setMenuid(Integer menuid) {
        this.id = menuid;
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
        return parentId;
    }

    public void setMenuparentid(String menuparentid) {
        this.parentId = menuparentid;
    }

    @Override
    public String toString() {
        return "Menuinfo{" +
                "menuid=" + id +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", menuparentid='" + parentId + '\'' +
                ", ziList=" + ziList +
                '}';
    }
}
