package com.zyc.demo.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/6/10 22:19
 */
public class DemoTest {
    public static void main(String[] args) {
        predicateTest();
    }

    public static void defaultService(){
        Formula formula = new Formula(){
            @Override
            public double calculaste(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calculaste(2));

        System.out.println(formula.sqrt(16));
    }

    public static void  lambdaTest1(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,(a,b) -> a.compareTo(b));

        for(String str:names){
            System.out.println(str);
        }
    }


    public static void convertTest(){
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);

//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer value = converter.convert("123");
//        System.out.println(value);

        int num = 13;

        Converter<Integer, String> converter = (from) -> String.valueOf(from + num);
        String value = converter.convert(1234);
        System.out.println(value);
//        num = 5;
    }


    public static void personCreateTest(){

        PersonFactory<Person> personPersonFactory = Person::new;

        Person person = personPersonFactory.create("Perter", "Perter");
    }

    public static void predicateTest(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
