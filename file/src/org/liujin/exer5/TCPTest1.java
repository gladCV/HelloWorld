package org.liujin.exer5;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例1：客户端发送信息给服务端，服务端显示信息
 *
 *
 *
 * @author LiuJin
 * @date 2022-08-11 16:40
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. 创建Socket对象，指名服务器的IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8888);
            //2. 获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3. 写出数据的操作
            os.write("你好我是客户端妹妹".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4. 资源的关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //服务器
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        InputStreamReader reader = null;
        ByteArrayOutputStream bos = null;
        try {
            //1. 创建服务器端的ServerSocket，指名自己的端口号
            serverSocket = new ServerSocket(8888);
            //2. 调用accept方法表示接收来自于客户端的socket
            socket = serverSocket.accept();
            //3. 获取输入流
            is = socket.getInputStream();
            //4. 读取输入流的数据(方法一)
//            reader = new InputStreamReader(is);
//            char[] chars = new char[20];
//            int len;
//            while ((len=reader.read(chars)) != -1) {
//                System.out.println(new String(chars));
//            }
//            System.out.println(socket.getInetAddress());

            //方法二
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len=is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println(socket.getInetAddress().getHostAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //5. 资源的关闭
            if (reader != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
