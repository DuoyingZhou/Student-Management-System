package cn.ylc.student.service;

import cn.ylc.student.vo.Classes;

import java.sql.SQLException;
import java.util.List;

public interface IClassesService {
    /**
     * classes increasing operation
     * @param vo vo object used to increase number of classes
     * @return return true if success
     * @throws Exception
     */
    public boolean insert(Classes vo) throws Exception;

    /**
     * list all classes
     * @return
     * @throws SQLException
     */
    public List<Classes> list() throws SQLException;
}
