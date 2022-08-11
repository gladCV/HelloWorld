package org.liujin;

import org.junit.Test;

/**
 * @author LiuJin
 * @date 2022-08-09 15:23
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("10000", new User(10000, 18, "james"));
        dao.save("10001", new User(10001, 19, "durant"));
        System.out.println(dao.get("10001"));
        dao.update("10001", new User(10002, 20, "durant"));
        //System.out.println(dao.list());
        dao.list().forEach(System.out::println);
        dao.delete("10001");
        System.out.println(dao.map);
    }
    @Test
    public void test() {
        System.out.println();
    }
}
