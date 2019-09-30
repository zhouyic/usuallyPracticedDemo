package com.zyc.demo.test.clone.domain;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/5/3 11:39
 */
public class Children {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
