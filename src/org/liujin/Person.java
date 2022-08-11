package org.liujin;

import java.io.Serializable;
import java.util.*;

/**
 * @author shkstart
 * @date 2022-07-21 15:42
 */
public class Person<E> extends ArrayList<E> implements Serializable {
    private String name;
    private char sex;
    private int age;

    public Person() {
        E[] a = (E[]) new Object[10];
    }

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
    public static String show() {
        System.out.println("Person。。。。。。。。。。。。。。");
        return "";
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person的equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sex == person.sex && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }

    public static void show(List<? extends Map<Object, Object>> list) {
        Iterator<? extends Map<Object, Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map<Object, Object> map = iterator.next();
            Set<Map.Entry<Object, Object>> entries = map.entrySet();
            for (Map.Entry<Object, Object> entry : entries) {
                System.out.println(entry+"="+map.get(entry));
            }

        }
    }

}
