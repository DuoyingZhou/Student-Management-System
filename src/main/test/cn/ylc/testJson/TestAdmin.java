package cn.ylc.testJson;

import cn.ylc.student.vo.Admin;
import cn.ylc.util.ObjectToJSON;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TestAdmin {
    public static void main(String[] args) {
        List<Admin> all = new ArrayList<Admin>();
        for (int x = 0;x < 5 ;x++) {
            Admin vo = new Admin();
            vo.setAID("duoying@163.com");
            vo.setPASSWORD("11111111");
            vo.setLASTDATE(new Date());
            all.add(vo);
        }
        System.out.println(ObjectToJSON.convertorListToJson("allAdmin",all));
    }
}
