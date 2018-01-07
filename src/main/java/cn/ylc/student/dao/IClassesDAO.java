package cn.ylc.student.dao;

import cn.ylc.student.vo.Classes;

import java.sql.SQLException;

public interface IClassesDAO extends IDAO<Integer, Classes>{
    /**
     * find class name
     * @param CLASSNAME
     * @return
     * @throws SQLException
     */
    public Classes findByCLASSNAME(String CLASSNAME)throws SQLException;

}
