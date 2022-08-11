package org.liujin.exer5;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 *通信要素一：IP和端口号
     * IP地址: InetAddress
         *      ->唯一的标识Internet上的计算机（通信实体）
         *      ->本地回环地址（hostAddress）:127.0.0.1    主机名（hostName）: localhost
         *      ->IP地址分类方式一：IPV4 / IPV6
         *          ->IPV4:4个字节组成，4个0-255.大概42亿，30亿都在北美，亚洲4亿。2011年初已用尽。以点分十进制表示，如192.168.0.1
         *          ->IPV4:128位（16个字节），写成8个无符号整数，每个整数用四个十六进制位表示，数之间用冒号（:）分开，
         *              如 3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
         *      ->IP地址分类方式二：公网地址（万维网）和私有地址（局域网）
         *      ->特点：不易记忆
         *      ->【在java中使用InetAddress类代表IP】,实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
         *          两个常用方法：getHostName()/getHostAddress()
         * 端口号：端口号标识正在计算机上运行的进程（程序）
         *      ->不同的进程有不同的端口号
         *      ->被规定为一个十六位的整数0~65535
         *      ->端口分类：
         *          ->公认端口：0~1023（被预先定义的服务通信占用，如http占用端口80，FTP占用21）
         *          ->注册端口：1024~49151.分配给用户进程或应用程序。（如：Tomcat占用端口8080，MYSQL占用端口3306）
         *          ->动态/私有端口：49152~65535
         * 端口号与IP地址的组合得出一个网络套接字
 *
 *
 *
 * @author LiuJin
 * @date 2022-08-11 15:28
 */
public class InetAddressTest {
    @Test
    public void test() {
        try {
            InetAddress inet = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet);
            System.out.println(inet.getHostName());
            System.out.println(inet.getHostAddress());
            System.out.println(Arrays.toString(inet.getAddress()));
//            inet = InetAddress.getLocalHost();
//            System.out.println(inet);
//            inet = InetAddress.getByName("localhost");
//            System.out.println(inet);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
