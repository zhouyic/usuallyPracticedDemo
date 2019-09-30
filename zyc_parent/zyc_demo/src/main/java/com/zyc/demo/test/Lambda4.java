package com.zyc.java.test;

import com.zyc.demo.test.Converter;

/**
 * 和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的：
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/6/10 23:16
 */
public class Lambda4 {
    static int outterStaticNum;
    int outerNum;
    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        Converter<Integer, String> stringConverter2 = (from) -> {
            outterStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
