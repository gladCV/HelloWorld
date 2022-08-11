package org.liujin;

/**
 * @author liuin
 *
 */
public class HelloWorld {

    private String name;
    private int age;
    private static int num;

    public HelloWorld(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("静态代码块..........");
        num = 1;
        System.out.println(num);
    }
    {
        System.out.println("非静态代码块..........");
        name = "james";
        age = 10;
        Object o = new Object();
    }
    public HelloWorld() {
        System.out.println("构造器..............");
    }
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        HelloWorld.Dog dog = helloWorld.new Dog();
        dog.getName();
        Comparable c = new Comparable() {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
    class Dog {
        String name = "haha";

        public void getName() {
            System.out.println(this.name);
            System.out.println(HelloWorld.this.name);
        }
    }

}
