package cn.ylc.student.service.impl;

import cn.ylc.student.dao.IClassesDAO;
import cn.ylc.student.service.IClassesService;
import cn.ylc.student.vo.Classes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {
    @Resource
    private IClassesDAO classesDAO;
    @Override
    public boolean insert(Classes vo) throws Exception {
        if (this.classesDAO.findByCLASSNAME(vo.getCLASSNAME()) == null){
            return this.classesDAO.doCreate(vo);
        }
        return false;
    }

    @Override
    public List<Classes> list() throws SQLException {
        return this.classesDAO.findAll();
    }
}
