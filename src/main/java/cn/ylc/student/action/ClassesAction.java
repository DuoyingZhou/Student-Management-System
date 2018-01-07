package cn.ylc.student.action;

import cn.ylc.student.service.IClassesService;
import cn.ylc.student.vo.Classes;
import cn.ylc.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/pages/back/classes/*")
public class ClassesAction extends DefaultAction{
    @Resource
    private IClassesService classesService;

    @RequestMapping(value = "classes_list")
    public void list(HttpServletResponse response) {
        try {
            super.printObjectToList(response,"allClasses",this.classesService.list());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            super.request.setAttribute("ClassesAll", this.classesService.list());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    @RequestMapping(value = "classes_insert")
    public ModelAndView insert(Classes vo){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        try {
            if (this.classesService.insert(vo)){
                super.setMsgAndPath(mav,"classes.insert.success","classes.login.success");
            }else{
                super.setMsgAndPath(mav,"classes.insert.failure","classes.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @Override
    public String getText() {
        return "Classes";
    }}

