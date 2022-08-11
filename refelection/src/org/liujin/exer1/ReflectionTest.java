package org.liujin.exer1;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author LiuJin
 * @date 2022-08-11 19:25
 */
public class ReflectionTest {
    // 反射之前对Person的操作
    @Test
    public void test1() {
        Person person = new Person("james", 18);
        person.age = 10;
        System.out.println(person.toString());
        person.show();
    }
    // 反射之后对Person的操作
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //通过反射调用构造器创建Person类的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("durant", 12);
        System.out.println(obj);
        //通过反射调用指定的属性
        Field age = clazz.getDeclaredField("age");
        age.set(obj, 10);
        System.out.println(obj);
        //通过反射调用指定的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(obj);
        //通过反射调用Person类私有的构造器。属性和方法
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person liujin = (Person) constructor1.newInstance("liujin");
        System.out.println(liujin);
        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(liujin, "擎天柱");
        System.out.println(liujin);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(liujin, "中国");
    }
}
