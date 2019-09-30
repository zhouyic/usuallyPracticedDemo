package com.zyc.demo.test.newfeature.interfaceDef;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:27
 */
public class Car implements Vehicle,FourWheeler {
    @Override
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车");
    }
}
