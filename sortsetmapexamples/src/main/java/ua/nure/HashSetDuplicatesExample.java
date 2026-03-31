package ua.nure;

import java.util.HashSet;
import java.util.Set;

public class HashSetDuplicatesExample {
    public static void main(String[] args) {
        // Створюємо клас Person без перевизначення equals і hashCode
        class Person {
            private String firstName;
            private String lastName;
            private int age;

            public Person(String firstName, String lastName, int age) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
            }

            @Override
            public String toString() {
                return firstName + " " + lastName + " (" + age + " років)";
            }

            // Не перевизначаємо equals і hashCode!
        }

        // Створюємо два об'єкти з однаковими даними
        Person person1 = new Person("Іван", "Петренко", 30);
        Person person2 = new Person("Іван", "Петренко", 30);
        System.out.println("person1: " + person1.hashCode());
        System.out.println("person2: " + person2.hashCode());


        // Логічно це та сама людина, але для Java це різні об'єкти
        System.out.println("person1 == person2: " + (person1 == person2));  // false
        System.out.println("person1.equals(person2): "
                + person1.equals(person2));  // false (стандартна реалізація)

        // Додаємо обидва об'єкти в HashSet
        Set<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);

        // HashSet зберіг обидва об'єкти як унікальні!
        System.out.println("Розмір набору: " + people.size());  // 2
        System.out.println("Вміст набору: " + people);  // Обидві особи
    }
}