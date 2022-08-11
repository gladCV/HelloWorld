package org.liujin.exer2;

import org.junit.Test;

import java.io.*;

/**
 * @author LiuJin
 * @date 2022-08-09 20:12
 */
public class BufferedTest {
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 实例化文件对象
            fis = new FileInputStream("C:\\Users\\admin\\Desktop\\360度视频.mp4");
            fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\360度视频1.mp4");
//            fis = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\360度视频.mp4"));
//            fos = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\360度视频1.mp4"));
            // 实例化流对象
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 读取数据、写入数据
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=bis.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i]^5);
                }
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    @Test
    public void test1() {
        File file = new File("C:\\Users\\admin\\Desktop\\testFile");
        if (!file.exists()){
            boolean a = file.mkdir();
            if (a) {
                BufferedWriter writer = null;
                try {
                    File file1 = new File(file, "jingyesi.txt");

                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                    String str = null;
                    while ((str=bufferedReader.readLine()) != null) {
                        System.out.println(str);
                    }

//                    boolean b = file1.createNewFile();
//                    if (b) {
//                        writer = new BufferedWriter(new FileWriter(file1, true));
//                        writer.write("   静夜思  李白");
//                        writer.newLine();
//                        writer.write("窗前明月光，疑是地上霜。");
//                        writer.newLine();
//                        writer.write("举头望明月，低头思故乡。");
//                        writer.newLine();
//                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    @Test
    public void test2() {
        File file = new File("C:\\Users\\admin\\Desktop\\testFile");
        if (file.exists()){
            BufferedReader bufferedReader = null;
            try {
                File file1 = new File(file, "jingyesi.txt");
                bufferedReader = new BufferedReader(new FileReader(file1));
                String str = null;
                while ((str=bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
