package org.liujin.exer5;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例2：客户端发送文件给服务端，服务端将文件保存在本地
 *
 *
 * @author LiuJin
 * @date 2022-08-11 17:28
 */
public class TCPTest2 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8888);
            fis = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\360度视频.mp4"));
            os = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len=fis.read(bytes)) != -1) {
                os.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
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
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            long start = System.currentTimeMillis();
            fos = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\360度视频ddd.mp4"));
            //读取数据
            byte[] bytes = new byte[1024];
            int len;
            System.out.println("开始接收数据,来自"+socket.getInetAddress().getHostAddress());
            while ((len=is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("接收完成,用时"+(System.currentTimeMillis()-start)+"毫秒");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (is != null) {
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
        }
    }
}
