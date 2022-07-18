package org.liujin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liuin
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(new HelloWorld().getMoney());
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        if (a == null) {
            System.out.println("a = " + a);
        }
        System.out.println(a);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        // 这是单行注释
        /**
         * sdjsdsjd
         * dsdjsjdkhdsk
         */
        System.out.println("HelloWorld.main");
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println(args);

    }


    private int getMoney() {
        return 0;
    }
}
