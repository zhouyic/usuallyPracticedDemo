package com.zyc.demo.test.newfeature.interfaceDef;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:25
 */
public interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}
