package org.liujin;

import java.util.Objects;

/**
 * @author shkstart
 * @date 2022-07-21 15:44
 */
public class Student extends Person {
    private Long number = 1L;
    private int math;
    private int english;
    private int computer;
    public int language;
    public Student() {
    }
    public Student(long number, int math, int english, int computer) {
        this.number = number;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    public Student(String name, char sex, int age, long number, int math, int english, int computer) {
        super(name, sex, age);
        this.number = number;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + getName() +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                ", number=" + number +
                ", math=" + math +
                ", english=" + english +
                ", computer=" + computer +
                '}';
    }

    public void show1() {
        //super.show();
        System.out.println("Student11111111111。。。。。。。。。。。。。。");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number && math == student.math && english == student.english && computer == student.computer && language == student.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, math, english, computer, language);
    }
}
