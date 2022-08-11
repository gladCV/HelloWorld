package org.liujin;

/**
 * @author shkstart
 * @date 2022-07-20 16:11
 */
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getArea() {
        double radius = this.radius;
        return Math.PI*radius*radius;
    }

    public static void main(String[] args) {
/*        AreaOfCircle areaOfCircle = new AreaOfCircle(1.88);
        double area = areaOfCircle.getArea();
        System.out.println(area);*/
        int a = 10, b = 10;
        method(a, b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    public static void method(int a, int b) {
        a = a * 10;
        b = b * 20;
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.exit(0);
    }
}
