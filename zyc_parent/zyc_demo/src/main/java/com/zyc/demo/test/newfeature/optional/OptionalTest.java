package com.zyc.demo.test.newfeature.optional;

import java.util.Optional;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/7/21 17:34
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println(fullName.isPresent());
        System.out.println("full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println("fullName:"+fullName.map(s->"Hey"+s).orElse("Hey Stranger"));

        Optional<String> firstName = Optional.of("Tom");
        System.out.println("firstName:"+ firstName.isPresent());
        System.out.println("firstName:"+ firstName.orElseGet(()->"[none]"));
        System.out.println("firstName:"+ firstName.orElse("hey Strang"));
    }

}

