package cn.ylc.util.action;

import cn.ylc.util.ObjectToJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public abstract class DefaultAction {
    @Resource
    private MessageSource messageSource;
//
//    @Autowired
//    protected HttpServletRequest request = null;
    private Integer currentPage = 1;
    private Integer lineSize = 2; //number of records on each page

    public Integer getCurrentPage() {
        return currentPage;
    }

//    public void setCurrentPage(Integer currentPage) {
//        this.currentPage = currentPage;
//    }

    public Integer getLineSize() {
        return lineSize;
    }

//    public void setLineSize(Integer lineSize) {
//        this.lineSize = lineSize;
//    }

    public void handSplit(HttpServletRequest request, HttpServletResponse response){
        try {
            this.currentPage = Integer.parseInt(request.getParameter("cp"));
        }catch (Exception e){}
        try {
            this.lineSize = Integer.parseInt(request.getParameter("ls"));
        }catch (Exception e){}
    }

    public void print(HttpServletResponse response,Object msg){
        try {
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * obtain resource according to the key
     * @param key the key to be read
     * @param param params set
     * @return
     */
    public String getResource(String key, String...param){
        return this.messageSource.getMessage(key, param, Locale.getDefault());
    }

    /**
     * set message and skip path, which are read from resource files
     * @param mav
     * @param msg
     * @param path
     */
    public void setMsgAndPath(ModelAndView mav, String msg, String path){
        if (mav != null){
            if (this.getText()!= null){
                String [] result = this.getText().split("\\|");
                mav.addObject("msg",this.messageSource.getMessage(msg, result, Locale.getDefault()));
            }else{
                mav.addObject("msg",this.messageSource.getMessage(msg,null,Locale.getDefault()));
            }
            mav.addObject("path",this.messageSource.getMessage(path,null,Locale.getDefault()));
        }
    }
    /**
     * convert object to JSON
     * @param response
     * @param vo
     */
    public void printObjectToJson(HttpServletResponse response, Object vo){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJSON.convertObjectToJSON(vo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * List to JSON
     * @param response
     * @param name
     * @param all
     */
    public void printObjectToList(HttpServletResponse response,String name,List<?> all){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJSON.convertorListToJson(name,all));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * split pages
     * @param response
     * @param name
     * @param all
     * @param allRecorders
     */
    public void printObjectToListSplit(HttpServletResponse response,String name,List<?> all,Integer allRecorders){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJSON.convertorListSplitToJson(name,all,allRecorders));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract String getText();
}
