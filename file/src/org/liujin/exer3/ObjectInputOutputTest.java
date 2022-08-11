package org.liujin.exer3;

import org.junit.Test;

import java.io.*;

/**
 *
 * 对象流的使用
 * 1. ObjectInputStream    ObjectOutputStream
 * 2. 作用：用于存储和读取基本数据类型数据或对象的处理流，可以把java中的对象写入到数据源（文件）中。
 *
 * @author LiuJin
 * @date 2022-08-10 17:14
 */
public class ObjectInputOutputTest {
    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("object.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Person("james", 18));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /*
    反序列化过程
     */
    @Test
    public void test2() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("object.dat");
            ois = new ObjectInputStream(fis);
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
