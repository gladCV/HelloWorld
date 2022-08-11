package org.liujin.exer2;

/**
 * @author LiuJin
 * @date 2022-08-10 14:14
 */
public class Review {
    /*
    一、File类构造器
       =>new File(String filePath)/new File(String parentPath, String childPath)/new File(File file, String childPath)
    二、从文件读取到内存、从内存输出到文件
       1. 实例化File对象
       2. 实例化流对象
            =>流的分类：
                =>根据操作的数据：字符流（操作文本文件，.txt .java .c .cpp）、字节流（非文本文件 .jpg .mp3 .mp4 .avi）
                =>根据：节点流、处理流
                =>输入流、输出流
            =>流的实现类
            抽象基类           节点流                 缓冲流（处理流的一种）
            reader            FileReader            BufferedReader
            Writer            FileWriter            BufferedWriter
            InputStream       FileInputStream       BufferedInputStream
            OutputStream      FileInputStream       BufferedOutputStream
       3. 读取、输出数据
            read()、read(char[] c， int off, int length)、read(char[] c)
            write(char[] c)
       4. 关闭流

     */
}
