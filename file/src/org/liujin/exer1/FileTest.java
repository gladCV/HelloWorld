package org.liujin.exer1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File类的使用
 * 1、file对象代表一个文件或目录
 * 2、生命在java.io包
 * 3、并未涉及到读取或写入内容
 * 4、后续file对象会作为参数传递到流的构造器中，作为读取或写入的”终点“
 * @author LiuJin
 * @date 2022-08-09 16:18
 */
public class FileTest {
    /*
    1.创建File类的实例
        File(String filePath)
        File(String parentPath, String childPath)
        File(File parentFile, String childPath)
    2.
    相对路径：相较于某个路径下，指明的路径
    绝对路径：包含盘符在内的文件或目录的路径

    3.路径分隔符：windows:\\  unix:/

     */
    @Test
    public void test1() {
        //相对于当前module
        File file = new File("hello.txt");
        File file1 = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld\\file\\new.txt");
        System.out.println(file);
        System.out.println(file1);
        File file2 = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld", "file");
        System.out.println(file2);
        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);
    }
    @Test
    public void test2() {
        File file = new File("hello.txt");
        File file1 = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld\\file\\file.iml");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());


        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
    }
    @Test
    public void test3(){
        File file = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld");
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    /*
    File类的创建功能
        =>public boolean createNewFile():创建文件,存在则不创建
        =>public boolean mkdir():创建文件目录，存在则不创建，上级目录不存在也不创建
        =>public boolean mkdirs():创建文件，目录不存在则创建目录
    File类的删除功能
        =>public boolean delete():删除文件和目录
     */
    @Test
    public void test4(){
        File file = new File("hello.txt");
        File file2 = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld\\file\\test");
        File file3 = new File(file2,"hello.txt");
        try {
            System.out.println(file.createNewFile());
            System.out.println(file2.mkdir());
            System.out.println(file2.mkdirs());
            System.out.println(file3.createNewFile());
            System.out.println(file2.delete());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File file = new File("hello.txt");
        File file1 = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld\\file\\new.txt");
        System.out.println(file);
        System.out.println(file1);
        File file2 = new File("D:\\other_software\\liujin\\JavaProject\\HelloWorld", "file");
        System.out.println(file2);
        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);
    }
}
