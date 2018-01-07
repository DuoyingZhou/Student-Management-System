package cn.ylc.student.vo;

import java.io.Serializable;

public class Student implements Serializable {
    private String STUDENTID;
    private String NAME;
    private Integer AGE;
    private Integer GENDER;
    private String ADDRESS;
    private Classes CLASSES;

    public String getSTUDENTID() {
        return STUDENTID;
    }

    public void setSTUDENTID(String STUDENTID) {
        this.STUDENTID = STUDENTID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getAGE() {
        return AGE;
    }

    public void setAGE(Integer AGE) {
        this.AGE = AGE;
    }

    public Integer getGENDER() {
        return GENDER;
    }

    public void setGENDER(Integer GENDER) {
        this.GENDER = GENDER;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public Classes getCLASSES() {
        return CLASSES;
    }

    public void setCLASSES(Classes CLASSES) {
        this.CLASSES = CLASSES;
    }
}
