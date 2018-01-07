package cn.ylc.student.vo;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    private String AID;
    private String PASSWORD;
    private Date LASTDATE;

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Date getLASTDATE() {
        return LASTDATE;
    }

    public void setLASTDATE(Date LASTDATE) {
        this.LASTDATE = LASTDATE;
    }
}
