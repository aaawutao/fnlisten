package com.aaa.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Table(name="backstage_user")
public class Backstage_User implements UserDetails {

    private Integer backstage_userid; //账号编号

    private String backstage_uname;//账号用户名

    private String  backstage_upwd;//账号密码

    private Integer empid;//员工编号

    private Integer backstage_type;//账号类型(管理0,主播1,默认生成主播信息)

    private String  backstage_js;//介绍

    private String  backstage_photo;//头像
    //ISEXPIRED 过期
    private Integer isexpired;
    //ISLOCKED 锁
    private Integer islocked;
    //认证是否过期
    private Integer iscreexpired;
    //是否禁用
    private Integer isenable;

    //用户所拥有的路径
    List<Map<String,Object>> urls;

    public List<Map<String, Object>> getUrls() {
        return urls;
    }

    public void setUrls(List<Map<String, Object>> urls) {
        this.urls = urls;
    }

    public Integer getIsexpired() {
        return isexpired;
    }

    public void setIsexpired(Integer isexpired) {
        this.isexpired = isexpired;
    }

    public Integer getIslocked() {
        return islocked;
    }

    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    public Integer getIscreexpired() {
        return iscreexpired;
    }

    public void setIscreexpired(Integer iscreexpired) {
        this.iscreexpired = iscreexpired;
    }

    public Integer getIsenable() {
        return isenable;
    }

    public void setIsenable(Integer isenable) {
        this.isenable = isenable;
    }

    public Integer getBackstage_userid() {
        return backstage_userid;
    }

    public void setBackstage_userid(Integer backstage_userid) {
        this.backstage_userid = backstage_userid;
    }

    public String getBackstage_uname() {
        return backstage_uname;
    }

    public void setBackstage_uname(String backstage_uname) {
        this.backstage_uname = backstage_uname;
    }

    public String getBackstage_upwd() {
        return backstage_upwd;
    }

    public void setBackstage_upwd(String backstage_upwd) {
        this.backstage_upwd = backstage_upwd;
    }





    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getBackstage_type() {
        return backstage_type;
    }

    public void setBackstage_type(Integer backstage_type) {
        this.backstage_type = backstage_type;
    }

    public String getBackstage_js() {
        return backstage_js;
    }

    public void setBackstage_js(String backstage_js) {
        this.backstage_js = backstage_js;
    }

    public String getBackstage_photo() {
        return backstage_photo;
    }

    public void setBackstage_photo(String backstage_photo) {
        this.backstage_photo = backstage_photo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.backstage_uname;
    }

    @Override
    public String getUsername() {
        return this.backstage_upwd;
    }

    /**
     * 账户已过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.isexpired==0;
    }
    /**
     * 账户是否被锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.islocked==0;
    }
    /**
     * 认证是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return this.iscreexpired==0;
    }
    /**
     * 是否禁用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return this.isenable==0;
    }
    @Override
    public String toString() {
        return "Backstage_User{" +
                "backstage_userid=" + backstage_userid +
                ", backstage_uname='" + backstage_uname + '\'' +
                ", backstage_upwd='" + backstage_upwd + '\'' +
                ", empid=" + empid +
                ", backstage_type=" + backstage_type +
                ", backstage_js='" + backstage_js + '\'' +
                ", backstage_photo='" + backstage_photo + '\'' +
                ", isexpired=" + isexpired +
                ", islocked=" + islocked +
                ", iscreexpired=" + iscreexpired +
                ", isenable=" + isenable +
                ", urls=" + urls +
                '}';
    }
}
