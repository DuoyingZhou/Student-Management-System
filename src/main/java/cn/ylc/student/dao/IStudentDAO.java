package cn.ylc.student.dao;

import cn.ylc.student.vo.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO extends IDAO<String,Student> {
    public List<Student> findAllBySplit(Integer currentPage, Integer  lineSize)throws SQLException;

    public Integer getAllCount()throws SQLException;

    public boolean doRemoverBatch(List<String> ids)throws SQLException;

}
