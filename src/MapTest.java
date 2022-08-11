import java.io.IOException;
import java.util.*;

/**
 * @author LiuJin
 * @date 2022-08-08 17:13
 */
public class MapTest {
    public static void main(String[] args) throws IOException {
//        Map<Object, Object> map = new HashMap<Object, Object>();
//        map.put("name", "James");
//        map.put("age", 18);
//        map.put(null, "4");
//        System.out.println(map.get(null));
//        Set<Object> set = map.keySet();
//        for (Map.Entry<Object, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        System.out.println(map.values());
//        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//        properties.load(fileInputStream);
//        System.out.println(properties);
//        properties.setProperty("gender", "M");
//        properties = System.getProperties();
//        System.out.println(properties.size());
//        Collections
//        for (Object o : set) {
//            System.out.println(o+" "+map.get(o));
//        }
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i < 10 && sc.hasNext()) {
            int a = sc.nextInt();
            list.add(a);
            sc = new Scanner(System.in);
            ++i;
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        System.out.println(list);

    }
}
