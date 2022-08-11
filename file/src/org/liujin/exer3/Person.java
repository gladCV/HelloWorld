package org.liujin.exer3;

import java.io.Serializable;

/**
 * @author LiuJin
 * @date 2022-08-10 17:38
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1454854512154457L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
