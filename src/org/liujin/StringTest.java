package org.liujin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author LiuJin
 * @date 2022-07-27 16:19
 */
public class StringTest {
    public static void main(String[] args) {
/*        String str = "12hello34world5java7891mysql456";
        String str1 = str.replaceAll("\\d+", ",");
        System.out.println(str1);
        String str2 = str1.replaceAll("^,|,$", "");
        System.out.println(str2);
        String str3 = "org.liujin.helloWorld.java";
        String[] strings = str3.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }*/
        //将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
        //String str = "abcdefg";
//        System.out.println("转换前: " + str);
        //str = myReverse(str, 2, 5);
        //str = myReverse2(str, 2, 5);
//        StringBuilder StringBuilder = myReverse3(str, 2, 5);
//        System.out.println("转换后: " + StringBuilder);
//        char[] chars = StringBuilder.toString().toCharArray();
//        Arrays.sort(chars);
//        System.out.println(chars);
        //test3();
        //change("2022-07-28 08:22:33");
        //test1();
//        StringBuffer stringBuffer = new StringBuffer("abc");
//        stringBuffer.insert(1, false);
//        System.out.println(stringBuffer);
//        char[] chars = new char[20];
//        stringBuffer.getChars(0, stringBuffer.length(), chars, 0);
//        System.out.println(chars);
//        System.out.println(stringBuffer.capacity());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date(2020, 9, 8);
//        String format = simpleDateFormat.format(date);
//        System.out.println(simpleDateFormat1.format(date));
//        System.out.println(format);
        Person[] a = new Person[5];
        String[] names = {"james", "kobe", "jordan", "durant", "anthony"};
        for (int i = 0; i < a.length; i++) {
            a[i] = new Person();
            a[i].setName(names[i]);
            a[i].setAge((int) Math.abs(Math.round(Math.random()*90-Math.random()*10)));
            a[i].setSex('F');
        }
        System.out.println(Arrays.toString(a));
//        Arrays.sort(a, (o1, o2) -> {
//            if (o1.getAge() > o2.getAge()) {
//                return 1;
//            } else if (o1.getAge() < o2.getAge()) {
//                return -1;
//            }
//            return 0;
//        });
        Arrays.sort(a, (o1, o2) -> {
            return (o1.getAge() > o2.getAge())?2:(o1.getAge() == o2.getAge())?0:-1;
//            if (o1.getAge() > o2.getAge()) {
//                return 1;
//            } else if (o1.getAge() < o2.getAge()) {
//                return -1;
//            }
//            return 0;
        });
        System.out.println(Arrays.toString(a));
    }
    public static void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
        System.out.println();

    }


    public static void test() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 10, 6, 12, 25, 30);
        System.out.println(localDateTime1);

//        System.out.println(localDateTime1.getYear());
//        System.out.println(localDateTime1.getMonthValue());
//        System.out.println(localDateTime1.getDayOfMonth());
//        System.out.println(localDateTime.getHour());
//        System.out.println(localDateTime1.getMinute());
//        System.out.println(localDateTime1.getSecond());
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(8);
        System.out.println(localDateTime2);
        Instant instant = Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli());
        System.out.println(System.currentTimeMillis());

    }
    private static void change(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //new Date()
            Date date = simpleDateFormat.parse(s);
            java.sql.Timestamp date1 = new java.sql.Timestamp(date.getTime());
            System.out.println(date);
            System.out.println(date1);
            System.out.println(date1.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public static String myReverse(String s, int start, int end) {
        String str1 = s.substring(0, start);
        String str2 = s.substring(end+1, s.length());
        String str = s.substring(start, end+1);
        char[] c = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < c.length/2; i++) {
            char temp = c[i];
            c[i] = c[c.length-1-i];
            c[c.length-1-i] = temp;
        }
        System.currentTimeMillis();
        for (int i = 0; i < c.length; i++) {
            stringBuilder.append(c[i]);
        }
        return str1+new String(stringBuilder)+str2;
    }

    public static String myReverse2(String s, int start, int end) {
        char[] chars = s.toCharArray();
        for (int i = start, j=end; i < j; i++,j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
    public static StringBuilder myReverse3(String s, int start, int end) {
        StringBuilder StringBuilder = new StringBuilder(s.substring(0, start));
        char[] chars = s.toCharArray();
        Integer[] a = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(a);
        //UnmodifiableArrayList UnmodifiableArrayList = null;
        System.out.println(list.size());
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (int i = end; i >= start ; i--) {
            StringBuilder.append(chars[i]);
        }
        return StringBuilder.append(s.substring(end+1));
    }
    public static void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }


}
