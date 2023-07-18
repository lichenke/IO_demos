package com.babyblue.july17;

import java.io.Serializable;

public class Dog implements Serializable {

    // 不指定serialVersionUID，如果执行了输出后，修改了类文件内容，如删除了某个方法，或添加了某个方法，则恢复时就无法恢复，因为UID不同了
    private static final long serialVersionUID = -90382197453796927L; //指定serialVersionUID，即使类文件有变化也能恢复
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}