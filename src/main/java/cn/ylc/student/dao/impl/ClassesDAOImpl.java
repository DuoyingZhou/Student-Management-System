package cn.ylc.student.dao.impl;

import cn.ylc.student.dao.IClassesDAO;
import cn.ylc.student.vo.Classes;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class ClassesDAOImpl extends SqlSessionDaoSupport implements IClassesDAO {

    @Autowired
    public ClassesDAOImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
    public boolean doCreate(Classes vo) throws SQLException {
        return super.getSqlSession().insert("ClassesNS.doCreate", vo) > 0;
    }

    @Override
    public boolean doUpdate(Classes vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Classes findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Classes> findAll() throws SQLException {
        return super.getSqlSession().selectList("ClassesNS.findAll");
    }

    @Override
    public List<Classes> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Classes findByCLASSNAME(String CLASSNAME) throws SQLException {
        return super.getSqlSession().selectOne("ClassesNS.findByCLASSNAME", CLASSNAME);
    }
}
