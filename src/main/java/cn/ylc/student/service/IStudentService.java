package cn.ylc.student.service;

import cn.ylc.student.vo.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {

    public boolean insert(Student vo)throws Exception;

    public Map<String,Object> listSplit(int currentPage, int lineSize)throws Exception;

    public boolean update(Student vo)throws Exception;

    public boolean delete(List<String> ids)throws Exception;

}
