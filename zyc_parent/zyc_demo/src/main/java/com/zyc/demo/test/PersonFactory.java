package com.zyc.demo.test;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/6/10 23:01
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
