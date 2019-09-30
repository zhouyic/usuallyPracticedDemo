package com.zyc.demo.test.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/9/28 19:26
 */
public class JSONDemo {
    public static void main(String[] args) {
        /**简单java转json字符串*/
//        objectToJSONStr();
        /**List<Object>转json字符串*/
//        listObjctToJSONStr();
        /**复杂java类转json字符串*/
//        listObjctToJSONStr2();

        /**json字符串转简单java对象*/
//        jsonToObject();

        /**json字符串转List<Object>对象*/
//        jsonToObject2();

        /**json字符串转复杂java对象*/
        jsonToObject3();


    }

    public static void  objectToJSONStr(){
        User user = new User("zhanshan", "12345");
        System.out.println(JSON.toJSONString(user));
    }

    public static void listObjctToJSONStr(){
        User u1 = new User("zhanshan", "12345");
        User u2 = new User("lisi", "7890123");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        System.out.println(JSON.toJSONString(list));
    }

    public static void listObjctToJSONStr2(){
        User u1 = new User("zhanshan", "12345");
        User u2 = new User("lisi", "7890123");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        UserGroup ug = new UserGroup("userGroup", list);
        System.out.println(JSON.toJSONString(ug));
    }

    public  static void jsonToObject(){
        //language=JSON
        String str = "{\"username\":\"zhansan\",\"password\":\"123456\"}";
        User user = JSON.parseObject(str, User.class);
        System.out.println("json字符串转简单java对象"+user.toString());
    }

    public  static void jsonToObject2(){
        String jsonStr2 = "[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]";
        List<User> users = JSON.parseArray(jsonStr2, User.class);
        System.out.println("json字符串转List<Object>对象:"+users.toString());
    }

    public  static void jsonToObject3(){
        String jsonStr3 = "{'name':'userGroup','users':[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]}";
        UserGroup userGroup = JSON.parseObject(jsonStr3, UserGroup.class);
        System.out.println("json字符串转复杂java对象:"+userGroup);
    }

}
