package com.zyc.demo.test.newfeature.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 9:09
 */
public class StreamTest {
    public static void main(String[] args) {
        /**filter()*/
        Stream<String> stream = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl").stream();
        System.out.println("***********************************************");
        List<String> collect = stream.filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(collect.toString());
        collect.forEach(System.out::println);
        System.out.println("*******************************************");
        /**map 方法*/
        List<Integer> list = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        list.stream().map(i->i*i).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*******************************************************");
        /**filter*/
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(s -> !s.isEmpty()).count();
        System.out.println(count);
        System.out.println("********************************");
        /**limit()*/
        Random r = new Random();
        r.ints().limit(10).forEach(System.out::println);
        System.out.println("********************************");
        /**sorted*/
        r.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("#######################################");
        List<String> tmp = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count1 = tmp.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println(count1);


        /***/
        List<String>tmp2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect1 = tmp2.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表:" + collect1);
        String ss =tmp2.stream().filter(s->!s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串:"+ss);

        /**统计*/
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stas = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表最大的数：" + stas.getMax());
        System.out.println("列表最小的数：" + stas.getMin());
        System.out.println("所有数之和：" + stas.getSum());
        System.out.println("平均数:"+stas.getAverage());




    }
}
