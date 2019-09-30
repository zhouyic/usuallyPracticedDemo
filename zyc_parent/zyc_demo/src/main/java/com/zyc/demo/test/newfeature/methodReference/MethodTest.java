package com.zyc.demo.test.newfeature.methodReference;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:59
 */
public class MethodTest {
    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        final List< Car > cars = Arrays.asList( car );
        System.out.println(cars);
        cars.forEach( Car::repair );
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }
}
