package cn.ylc.test;

import cn.ylc.student.service.IClassesService;
import cn.ylc.student.service.IStudentService;
import cn.ylc.student.vo.Classes;
import cn.ylc.student.vo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentServiceTest {

    private static ApplicationContext ctx ;
    private static IStudentService studentService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = ctx.getBean("studentServiceImpl",IStudentService.class);
    }
    @Test
    public void insert() throws Exception{
        Student vo = new Student();
        vo.setSTUDENTID("YLCTo832");
        vo.setNAME("doria");
        vo.setAGE(23);
        vo.setGENDER(0); // 1.male ，0.female
        vo.setADDRESS("xxxxxxxx St.xxxxx Rd.");
        Classes classes = new Classes();
        classes.setCLASSID(1);
        vo.setCLASSES(classes);
        TestCase.assertTrue(this.studentService.insert(vo));

    }
    @Test
    public void list() throws Exception {
        Map<String,Object> map = this.studentService.listSplit(1,2);
        System.out.println( map.get("allStudent"));
        System.out.println( map.get("studentCount"));
        TestCase.assertTrue(map.size() == 2);
    }

    @Test
    public void update()throws Exception{
        Student vo = new Student();
        vo.setNAME("wangwu");
        vo.setAGE(20);
        vo.setGENDER(1);
        vo.setADDRESS("queens");
        vo.setSTUDENTID("YLCTo832");
        Classes classes = new Classes();
        classes.setCLASSID(2);
        vo.setCLASSES(classes);
        TestCase.assertTrue(this.studentService.update(vo));
    }

    @Test
    public void delete() throws Exception {
        List<String> all = new ArrayList<String>();
        all.add("123");
        TestCase.assertTrue(this.studentService.delete(all));
    }




}
