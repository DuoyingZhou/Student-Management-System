package cn.ylc.student.vo;

import java.io.Serializable;
import java.util.List;

public class Classes implements Serializable {
    private Integer CLASSID;
    private String CLASSNAME;
    private String DESCRIPTION;
    private List<Student> STUDENTS;

    public List<Student> getSTUDENTS() {
        return STUDENTS;
    }

    public void setSTUDENTS(List<Student> STUDENTS) {
        this.STUDENTS = STUDENTS;
    }

    public Integer getCLASSID() {
        return CLASSID;
    }

    public void setCLASSID(Integer CLASSID) {
        this.CLASSID = CLASSID;
    }

    public String getCLASSNAME() {
        return CLASSNAME;
    }

    public void setCLASSNAME(String CLASSNAME) {
        this.CLASSNAME = CLASSNAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "CLASSID=" + CLASSID +
                ", CLASSNAME='" + CLASSNAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}
