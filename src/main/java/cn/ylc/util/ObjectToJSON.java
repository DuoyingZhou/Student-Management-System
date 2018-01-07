package cn.ylc.util;

import cn.ylc.student.vo.Admin;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ObjectToJSON {
    public static JSONObject convertObjectToJSON(Object vo){
        JSONObject obj = new JSONObject();
        Field [] field = vo.getClass().getDeclaredFields();
        for (int x = 0; x < field.length; x++){
//            System.out.println(field[x].getName());
            Field f = field[x];
            String methodName = "get" + f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
//            System.out.println(methodName);
            try {
                Method method = vo.getClass().getMethod(methodName);
                if ("Date".equalsIgnoreCase(f.getType().getSimpleName())){
                    Date date =(Date) method.invoke(vo);
                    obj.put(f.getName(),new SimpleDateFormat("yyyy-MM-dd").format(date));
                }else {
                    obj.put(f.getName(), method.invoke(vo));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static JSONObject convertorListToJson(String name, List<?> all) {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Iterator<?> iter = all.iterator();
        while(iter.hasNext()){
            array.add(convertObjectToJSON(iter.next()));
        }
        obj.put(name,array);
        return obj;
    }

    public static JSONObject convertorListSplitToJson(String name, java.util.List<?> all,Integer allRecorders) {
        JSONObject obj = convertorListToJson(name,all);
        obj.put("allRecorders",allRecorders);
        return obj;
    }
}
