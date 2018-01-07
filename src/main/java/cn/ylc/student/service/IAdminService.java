package cn.ylc.student.service;

import cn.ylc.student.vo.Admin;

public interface IAdminService {
    /**
     * realize admin login
     * @param vo contains fields which are used to check if login is legal: AID, PASSWORD
     * @return
     * @throws Exception
     */
    public Admin login(Admin vo) throws  Exception;

}
