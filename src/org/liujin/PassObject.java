package org.liujin;

/**
 * @author shkstart
 * @date 2022-07-20 21:23
 */
public class PassObject {
    public static void main(String[] args) {
        int n = 20;
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i+1));
        }
    }
    public void  printAreas(Circle c, int time) {
        System.out.println("Radius       Area");
        int i;
        for (i = 1; i <= time; i++) {
            System.out.print(i*1.0+"       ");
            System.out.println(Math.PI*i*i);
        }
        System.out.println("now radius is:"+i*1.0);
    }
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n-1)+fib(n-2);
        }
    }
}
