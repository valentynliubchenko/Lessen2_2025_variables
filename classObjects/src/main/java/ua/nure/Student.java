package ua.nure;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Student {
    // Fields
    private String name;
    private int age;
    private String course;
    private static int count = 0;


    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        count++;
        log.info("Run Student(String name, int age, String course) ");
    }

    // Constructor
    public Student(String name, int age) {
        this(name, age, "Not assigned");
        log.info("Run Student(String name, int age) ");
    }

    public Student() {
        this("Unknown", 0);
        log.info("Run Student()");
    }

    public Student(Student other) {
        this(other.name, other.age, other.course);
        log.info("Run copy Student ");
    }

    static public int  getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }
}
