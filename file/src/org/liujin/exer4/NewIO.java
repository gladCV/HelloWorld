package org.liujin.exer4;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author LiuJin
 * @date 2022-08-10 18:37
 */

public class NewIO {
    @Test
    public void test(){
        Path path = Paths.get("hello.txt");
        System.out.println(path);
    }
}
