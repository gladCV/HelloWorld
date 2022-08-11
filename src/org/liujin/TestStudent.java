package org.liujin;

/**
 * @author shkstart
 * @date 2022-07-21 15:49
 */
public class TestStudent {
    public static void main(String[] args) {
        Person student = new Student("james", 'M', 18, 2006310733, 99, 100, 100);
        Person a = new Person();

        System.gc();
        //System.out.println(student.getClass().getSuperclass());
    }

    @Override
    protected void finalize() {
        System.out.println("對象被释放---->"+this);
    }
}
