package cn.ylc.test;

import cn.ylc.util.MD5Code;

public class TestMD5code {
    public static void main(String[] args) {
        String email = "ylc@gmail.com";
        String password = "ylc";
        System.out.println(new MD5Code().getMD5ofStr(password+email));

    }
}
