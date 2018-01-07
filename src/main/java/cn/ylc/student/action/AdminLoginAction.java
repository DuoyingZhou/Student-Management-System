package cn.ylc.student.action;

import cn.ylc.student.service.IAdminService;
import cn.ylc.student.vo.Admin;
import cn.ylc.util.MD5Code;
import cn.ylc.util.action.DefaultAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(value = "/pages/back/*")
public class AdminLoginAction extends DefaultAction{
    @Resource
    private IAdminService adminService;
//    @Autowired
//    private HttpServletRequest request ;

    @RequestMapping(value = "admin_login")

    public ModelAndView login(HttpServletRequest request, Admin admin){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        try {
            // login password encoding
            admin.setPASSWORD(new MD5Code().getMD5ofStr(admin.getPASSWORD()+admin.getAID()));
            Admin vo = this.adminService.login(admin); // after successful login, get last date
            if (vo != null){
                super.setMsgAndPath(mav,"admin.insert.success","admin.login.success");
                request.getSession().setAttribute("AID",vo.getAID());
                request.getSession().setAttribute("LASTDATE",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLASTDATE()));
            }else{
                super.setMsgAndPath(mav,"admin.insert.failure","admin.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping(value = "admin_logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        request.getSession().invalidate(); // 表示session失效
        super.setMsgAndPath(mav,"admin.logout.success","admin.logout.failure");
        return mav;
    }
    @Override
    public String getText() {
        return "Admin";
    }
}
