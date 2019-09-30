package com.zyc.demo.test.newfeature.lambda;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 11:14
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest=new LambdaTest();
        /**声明类型*/
        MathOperation addition=(int x,int y)->x+y;
        MathOperation subtraction=(x,y)->x - y;
        MathOperation multiplication=(int x,int y)->{return x*y;};
        MathOperation division=(int x,int y)->x/y;
        System.out.println("10 + 5 = " + lambdaTest.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaTest.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaTest.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaTest.operate(10, 5, division));

        GreetingService greetingService1 = message -> System.out.println(message);
        GreetingService greetingService2 = (message) -> System.out.println(message);
        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
    }
    interface MathOperation{
        int operation(int x,int y);
    }
    interface GreetingService{
        void sayMessage(String message);

    }
    private int operate(int x,int y,MathOperation mathOperation){
        return mathOperation.operation(x,y);
    }
}
