package com.zyc.demo.test;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/6/10 22:20
 */
public interface Formula {
    double calculaste(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
