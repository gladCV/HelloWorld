package org.liujin.exer1;

/**
 * @author LiuJin
 * @date 2022-08-11 19:25
 */
public class Person {
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show() {
        System.out.println("你好啊");
    }
    private void showNation(String nation) {
        System.out.println("我是"+nation+"人");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
