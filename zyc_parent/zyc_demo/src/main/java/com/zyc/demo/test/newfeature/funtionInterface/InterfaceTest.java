package com.zyc.demo.test.newfeature.funtionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:40
 */
public class InterfaceTest {
    public static void main(String[] args) {
        /**函数式接口*/
        GreetingService greetingService=message -> System.out.println(message);
        greetingService.sendMessage("aaa");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("所有列表的参数："+list);
        /** Predicate<Integer> predicate = n -> true
            n 是一个参数传递到 Predicate 接口的 test 方法
            n 如果存在则 test 方法返回 true
         */
        eval(list, n -> true);

        /**Predicate<Integer> predicate1 = n -> n%2 == 0
        n 是一个参数传递到 Predicate 接口的 test 方法
        如果 n%2 为 0 test 方法返回 true
         */
        System.out.println("所有偶数：");
        eval(list,n->n%2==0);
        /**Predicate<Integer> predicate1 = n -> n%2 == 0
         n 是一个参数传递到 Predicate 接口的 test 方法
         如果 n%2 为 0 test 方法返回 true
         */
        System.out.println("所有大于3的数：");
        eval(list,n->n>3);


    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n:list){
            if(predicate.test(n)){
                System.out.println(n+"");
            }
        }

    }
}
