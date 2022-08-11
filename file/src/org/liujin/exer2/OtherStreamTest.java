package org.liujin.exer2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流的使用
 * 1、标准的输入输出流
 *      ->System.in   从键盘输入
 *      ->System.out  从控制台输出
 *      ->System类的setIn(InputStream is)/setOut(PrintStream ps)方法重新指定输入和输出的流
 * 2、打印流
 *      实现将基本数据类型的数据格式转化为字符串输出
 *      ->PrintStream
 *      ->PrintWriter
 * 3、数据流
 *
 * @author LiuJin
 * @date 2022-08-10 15:49
 */
public class OtherStreamTest {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        while (true) {
            System.out.println("请输入字符串：");
            str=br.readLine();
            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                System.out.println("程序结束");
                break;
            }
            System.out.println(str.toUpperCase());
        }
        br.close();
    }
    /*
        1、标准的输入输出流
            ->System.in   从键盘输入
            ->System.out  从控制台输出
            ->System类的setIn(InputStream is)/setOut(PrintStream ps)方法重新指定输入和输出的流
     */
    @Test
    public void test() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        while (true) {
            System.out.println("请输入字符串：");
            str=br.readLine();
            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                System.out.println("程序结束");
                break;
            }
            System.out.println(str.toUpperCase());
        }
        br.close();
    }

}
