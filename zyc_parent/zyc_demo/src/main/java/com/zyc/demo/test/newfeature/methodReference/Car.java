package com.zyc.demo.test.newfeature.methodReference;

import java.util.function.Supplier;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:59
 */
public class Car {

    static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    static void collide(final Car car){
        System.out.println("collide:"+car.toString());
    }
    void follow(final Car another){
        System.out.println("follow:"+another.toString());
    }
    void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
