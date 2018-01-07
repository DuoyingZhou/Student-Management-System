package cn.ylc.test;

import cn.ylc.student.service.IAdminService;
import cn.ylc.student.service.IClassesService;
import cn.ylc.student.vo.Admin;
import cn.ylc.student.vo.Classes;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassesServiceTest {

    private static ApplicationContext ctx ;
    private static IClassesService classesService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = ctx.getBean("classesServiceImpl",IClassesService.class);
    }
    @Test
    public void insert() throws Exception{
        Classes vo = new Classes();
        vo.setCLASSNAME("YL005");
        vo.setDESCRIPTION("a new class");
        TestCase.assertTrue(this.classesService.insert(vo));
    }

    @Test
    public void list() throws Exception{
        System.out.println(this.classesService.list());
    }
}
