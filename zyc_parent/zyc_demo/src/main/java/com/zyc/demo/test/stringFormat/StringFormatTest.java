package com.zyc.demo.test.stringFormat;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 18:45
 */
public class StringFormatTest {
    public static void main(String[] args) {
        String str=null;
        str = String.format("Hi,%s", "小超");
        System.out.println(str);
        str = String.format("Hi,%s,%s %s", "小超", "是个", "大帅哥");
        System.out.println(str);
        System.out.printf("字母c的大写是：%c",'C');
    }
}
