package ua.nure;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person withName(String newName) {
        return new Person(newName);
    }
}