package ua.nure;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    // Конструктор, геттери, тощо...

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        // Сортування за прізвищем
        return this.lastName.compareTo(other.lastName);
        // Або за віком: return Integer.compare(this.age, other.age);
    }
    @Override
    public String toString() {
        return lastName + " " + firstName + ", " + age + " років";
    }
}