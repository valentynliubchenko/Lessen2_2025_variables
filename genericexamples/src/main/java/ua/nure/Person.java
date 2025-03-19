package ua.nure;

public class Person  implements Comparable<Person> {
    private String name;
    private int age;

    // Конструктори і гетери/сетери...
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " років)";
    }

    @Override
    public int compareTo(Person other) {
        // Порівнюємо за віком
        return Integer.compare(this.age, other.age);

        // Або можна так:
        // return this.age - other.age;
    }
}