package com.zyc.demo.test;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/6/10 22:49
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);


}
