package cn.ylc.student.service.impl;

import cn.ylc.student.dao.IAdminDAO;
import cn.ylc.student.service.IAdminService;
import cn.ylc.student.vo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminDAO adminDAO;

    @Override
    public Admin login(Admin vo) throws Exception {
        Admin admin = this.adminDAO.findLogin(vo);
        if (admin != null){ //login success
            vo.setLASTDATE(new Date());
            this.adminDAO.doUpdate(vo);
        }
        return admin;
    }
}
