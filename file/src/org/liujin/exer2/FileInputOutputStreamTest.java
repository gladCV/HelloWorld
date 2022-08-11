package org.liujin.exer2;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiuJin
 * @date 2022-08-09 19:57
 */
public class FileInputOutputStreamTest {
    /*
    读取图片内容输出到另一图片
    */
    @Test
    public void test1() {
        FileInputStream reader = null;
        FileOutputStream writer = null;
        try {
            //1 实例化file对象
            File fileToRead = new File("1.jpeg");
            File fileToWrite = new File("2.jpeg");
            //2 实例化流对象
            reader = new FileInputStream(fileToRead);
            writer = new FileOutputStream(fileToWrite);
            //3 读写数据
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len= reader.read(bytes)) != -1) {
                writer.write(bytes, 0, len);
//                String str = new String(chars, 0, len);
//                System.out.println(str);
//                writer.write(Integer.parseInt(str));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }  finally {
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
