package org.liujin.exer2;

import org.junit.Test;

import java.io.*;

/**
 *
 * 一、流的分类
 *    操作数据单位：字节流、字符流
 *    数据的流向：输入流、输出流
 *    流的角色：节点流、处理流
 * 二、流的体系结构
 *    抽象基类             节点流（文件流）            缓冲流（处理流的一种）
 *    InputStream         FileInputStream          BufferedInputStream
 *    OutputStream        FileOutputStream         BufferedOutputStream
 *    Reader              FileReader               BufferedReader
 *    Writer              FileWriter               BufferedWriter
 * 三、结论
 *    对于文本文件（.txt, .java, .c .cpp），使用字符流处理
 *    对于非文本文件（.jpg, .mp3 .mp4 .avi .doc .ppt），使用字节流处理
 *
 *
 * @author LiuJin
 * @date 2022-08-09 18:36
 */
public class FileReaderWriterTest {

    /*
    将文件内容读入程序并输出到控制台
     */
    @Test
    public void test1() {
        Reader reader = null;
        try {
            //实例化File类对象，指明要操作的文件
            File file = new File("hello.txt");
            //提供具体的流
            reader = new FileReader(file);
            /*
            char[] chars = new char[20];
            数据的读入
            reader.read(chars);
            System.out.println(reader.read(chars));
            System.out.println(chars);
            */
            int data = reader.read();
            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
            //System.out.println(reader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /*
    将文件内容读入程序并输出到控制台
     */
    @Test
    public void test3() {
        Reader reader = null;
        try {
            //实例化File类对象，指明要操作的文件
            File file = new File("hello.txt");
            //提供具体的流
            reader = new FileReader(file);
            char[] chars = new char[5];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /*
    从内存中写出数据到文件
    说明：
    1、输出操作，对应的File可以不存在。
        --如果文件不存在，会自动创建文件
        --如果存在:
            --构造器为FileWriter(file)/FileWriter(file, false) 则覆盖原文件
            --构造器为FileWriter(file, true) 则在文件末尾添加
     */
    @Test
    public void test2() {
        try {
            //实例化File类对象，指明要操作的文件
            File file = new File("hello.txt");
            //提供具体的流
            Writer writer = new FileWriter(file, true);
            //writer.append("sss");
            writer.write("liujin\n");
            writer.write(" hello xian");
            //System.out.println(reader.read());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    读取文件内容输出到另一文件
     */
    @Test
    public void test4() {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            //1 实例化file对象
            File fileToRead = new File("hello.txt");
            File fileToWrite = new File("jingyesi.txt");
            //2 实例化流对象
            reader = new FileReader(fileToRead);
            writer = new FileWriter(fileToWrite);
            //3 读写数据
            char[] chars = new char[5];
            int len = 0;
            while ((len= reader.read(chars)) != -1) {
//                String str = new String(chars, 0, len);
//                System.out.println(str);
                writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

}
