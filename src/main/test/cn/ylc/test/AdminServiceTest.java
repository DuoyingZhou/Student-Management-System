package cn.ylc.test;

import cn.ylc.student.service.IAdminService;
import cn.ylc.student.vo.Admin;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class AdminServiceTest {

    private static ApplicationContext ctx ;
    private static IAdminService adminService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        adminService = ctx.getBean("adminServiceImpl",IAdminService.class);
    }
    @Test
    public void login() throws Exception {
        Admin admin = new Admin();
        admin.setAID("ylc@gmail.com");
        admin.setPASSWORD("719772547E99BCA2CFCF0AD6F7F914F9");
        System.out.println(this.adminService.login(admin));
    }
}
