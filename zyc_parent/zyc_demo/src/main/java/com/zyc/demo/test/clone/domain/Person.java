package com.zyc.demo.test.clone.domain;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/5/3 11:29
 */
public class Person implements Cloneable{
    private String name;
    private Integer age;

    private Children children;

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

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                '}';
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
