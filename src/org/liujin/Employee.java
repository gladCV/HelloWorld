package org.liujin;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author LiuJin
 * @date 2022-08-08 15:45
 */
public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            return this.name.compareTo(employee.name);
        }
        return 0;
    }

    public static void main(String[] args) {
        Comparator<Employee> com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    if (e1.birthday.getYear() != e2.birthday.getYear()) {
                        return Integer.compare(e1.birthday.getYear(), e2.birthday.getYear());
                    }
                    if (e1.birthday.getMonth() != e2.birthday.getMonth()) {
                        return Integer.compare(e1.birthday.getMonth(), e2.birthday.getMonth());
                    }
                    return Integer.compare(e1.birthday.getDay(), e2.birthday.getDay());
                }
                return 0;
            }
        };
        TreeSet<Employee> employees = new TreeSet<>(com);
        Employee employee = new Employee("james", 38, new MyDate(1984, 12, 31));
        Employee employee1 = new Employee("kobe", 45, new MyDate(1977, 11, 31));
        Employee employee2 = new Employee("durant", 28, new MyDate(1986, 1, 31));
        Employee employee3 = new Employee("curry", 35, new MyDate(1986, 2, 31));
        Employee employee4 = new Employee("brown", 30, new MyDate(1981, 8, 31));
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        for (Employee employee5 : employees) {
            System.out.println(employee5);
        }

    }
}
