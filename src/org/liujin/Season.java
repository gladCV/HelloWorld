package org.liujin;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author LiuJin
 * @date 2022-08-05 10:16
 * Collection:
 *   --List:
 *       --ArrayList:
 *       --LinkedList:
 *       --Vector
 *   --Set:
 *       --HashSet:
 *          --LinkedHashSet:
 *       --TreeSet
 * Map:
 *   --HashMap
 *   --HashTable
 */
public class Season {
    public static void main(String[] args) {
        Collection set = new HashSet();
        set.add("s");
        set.add("a");
        set.add("d");

        set.forEach(System.out::println);
        //boolean a =set.add("d");
        //System.out.println(a);
//        for (Object s : set) {
//            System.out.println(s);
//        }
    }

    public void test() {
        System.out.println(System.currentTimeMillis());
    }

}
