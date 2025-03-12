package ua.nure;

public class Student2 extends Person{
    private int studentId;

    public Student2(String name, int studentId) {
        super(name);
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student2{" +
                " name: " + getName()+
                " studentId: " + studentId +
                '}';
    }
}
