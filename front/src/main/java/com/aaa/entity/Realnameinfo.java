package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Realnameinfo {
    private Integer rid;
    private String rtype;
    private String rname;
    private String ridcard;
    private String ridcardpositivepic;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date certifiesdate;
    private Integer front_userid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRidcard() {
        return ridcard;
    }

    public void setRidcard(String ridcard) {
        this.ridcard = ridcard;
    }

    public String getRidcardpositivepic() {
        return ridcardpositivepic;
    }

    public void setRidcardpositivepic(String ridcardpositivepic) {
        this.ridcardpositivepic = ridcardpositivepic;
    }

    public Date getCertifiesdate() {
        return certifiesdate;
    }

    public void setCertifiesdate(Date certifiesdate) {
        this.certifiesdate = certifiesdate;
    }

    public Integer getFront_userid() {
        return front_userid;
    }

    public void setFront_userid(Integer front_userid) {
        this.front_userid = front_userid;
    }

    @Override
    public String toString() {
        return "Realnameinfo{" +
                "rid=" + rid +
                ", rtype='" + rtype + '\'' +
                ", rname='" + rname + '\'' +
                ", ridcard='" + ridcard + '\'' +
                ", ridcardpositivepic='" + ridcardpositivepic + '\'' +
                ", certifiesdate=" + certifiesdate +
                ", front_userid=" + front_userid +
                '}';
    }
}
