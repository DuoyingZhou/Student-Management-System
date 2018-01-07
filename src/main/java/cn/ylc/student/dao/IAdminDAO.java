package cn.ylc.student.dao;

import cn.ylc.student.vo.Admin;

import java.sql.SQLException;

public interface IAdminDAO extends IDAO<String,Admin> {
    /**
     * realise login query operation
     * @param vo contains items used for querying (AID, PASSWORD)
     * @return returns last date
     * @throws SQLException
     */
    public Admin findLogin(Admin vo)throws SQLException;
}
