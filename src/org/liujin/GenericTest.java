package org.liujin;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author LiuJin
 * @date 2022-08-09 11:07
 */
public class GenericTest {
    public static void main(String[] args) {
//        ArrayList<Person> people = new ArrayList<>();
//        people.add(new Person("james", 'M', 18));
//        people.add(new Person("josh", 'M', 18));
//        people.add(new Person("joker", 'M', 18));
//        people.add(new Person("jj", 'M', 18));
//        System.out.println(people.contains(new Person("jj", 'M', 18)));
        ArrayList<HashMap<Object, Object>> arrayList = new ArrayList<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(123, 123);
        hashMap.put(1234, 123);
        arrayList.add(hashMap);
        Person.show(arrayList);
    }
}
