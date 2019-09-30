package com.zyc.demo.test.clone.utils;


import com.zyc.demo.test.clone.domain.Children;
import com.zyc.demo.test.clone.domain.Person;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/5/3 11:34
 */
public class TestUtils {
    public static void main(String[] args) throws CloneNotSupportedException {
//        test1();
//        test2();
        test3();
    }


    public static void test1() throws CloneNotSupportedException {

        Person p1=new Person();
        p1.setName("张三");
        p1.setAge(18);


        Person p2 = p1.clone();

        System.out.println(p1+":对象的hashcode:"+p1.hashCode());
        System.out.println(p2+":对象的hashcode:"+p2.hashCode());
    }

    /**
     * 浅表复制：
     *  克隆对象是一个新对象
     *  克隆对象的成员变量和原对象的成员变量是同一个数据（底层hashcode一致）
     *
     *
     * @throws CloneNotSupportedException
     */
    public static void test2() throws CloneNotSupportedException {

        Person p1=new Person();
        p1.setName("张三");
        p1.setAge(18);
        Children c1=new Children();
        c1.setName("李四");
        c1.setAge(28);
        p1.setChildren(c1);
        Person p2 = p1.clone();

        System.out.println(p1+":对象的hashcode:"+p1.hashCode()+",children的hashcode:"+p1.getChildren().hashCode());
        System.out.println(p2+":对象的hashcode:"+p2.hashCode()+",children的hashcode:"+p2.getChildren().hashCode());
    }

    /**
     * 浅表复制的弊端:原对象的属性统计同步更新到克隆对象
     *
     * @throws CloneNotSupportedException
     */
    public static void test3() throws CloneNotSupportedException {

        Person p1=new Person();
        p1.setName("张三");
        p1.setAge(18);
        Children c1=new Children();
        c1.setName("李四");
        c1.setAge(28);
        p1.setChildren(c1);
        Person p2 = p1.clone();

        System.out.println(p1.getChildren());
        System.out.println(p2.getChildren());

        c1.setName("张三丰");
        
        System.out.println(p1.getChildren());
        System.out.println(p2.getChildren());
    }
}
