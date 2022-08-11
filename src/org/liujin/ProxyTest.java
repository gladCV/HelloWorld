package org.liujin;

/**
 * @author LiuJin
 * @date 2022-07-25 15:41
 */
public class ProxyTest {
    public static void main(String[] args) {
        Singer singer = new Singer();
        SingerProxy singerProxy = new SingerProxy(singer);
        singerProxy.sing();
    }
}

interface Entertainment {
    int i = 9;
    void sing();

    default void entertain() {
        System.out.println("entertain");
    }
}

class Singer implements Entertainment {
    @Override
    public void sing() {
        System.out.println("Singer is singing!");
    }
}

class SingerProxy implements Entertainment {
    private Entertainment entertainment = null;
    public SingerProxy(Entertainment entertainment) {
        this.entertainment = entertainment;
    }
    public void check() {
        System.out.println("SingerProxy is connecting Singer!");
    }
    @Override
    public void sing() {
        System.out.println(Entertainment.i);
        check();
        entertain();
        entertainment.sing();
    }
}
