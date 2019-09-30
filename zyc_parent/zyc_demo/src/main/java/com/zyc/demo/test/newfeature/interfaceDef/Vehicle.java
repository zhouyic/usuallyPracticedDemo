package com.zyc.demo.test.newfeature.interfaceDef;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:24
 */
public interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }
    static void blowHorn(){
        System.out.println("按喇叭....");
    }
}
