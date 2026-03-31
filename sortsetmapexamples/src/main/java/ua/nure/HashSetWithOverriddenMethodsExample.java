package ua.nure;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetWithOverriddenMethodsExample {
    public static void main(String[] args) {
        // Клас Person з перевизначеними equals і hashCode
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


            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Person person = (Person) o;

                if (age != person.age) return false;
                if (!Objects.equals(firstName, person.firstName)) return false;
                return Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                int result = firstName != null ? firstName.hashCode() : 0;
                result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
                result = 31 * result + age;
                return result;
            }
        }

        // Створюємо два об'єкти з однаковими даними
        Person person1 = new Person("Іван", "Петренко", 30);
        Person person2 = new Person("Іван", "Петренко", 30);

        // Тепер об'єкти вважаються рівними за equals
        System.out.println("person1 == person2: "
                + (person1 == person2));  // false (різні об'єкти)
        System.out.println("person1.equals(person2): "
                + person1.equals(person2));  // true (однакові дані)
        System.out.println("person1.hashCode() == person2.hashCode(): " +
                (person1.hashCode() == person2.hashCode()));  // true


        System.out.println("person1: " + person1.hashCode());
        System.out.println("person2: " + person2.hashCode());


        // Додаємо обидва об'єкти в HashSet
        Set<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);

        // Тепер HashSet розпізнає дублікати!
        System.out.println("Розмір набору: " + people.size());  // 1
        System.out.println("Вміст набору: " + people);  // Тільки одна особа

        // Додаємо ще одну людину з іншими даними
        Person person3 = new Person("Марія", "Петренко", 30);
        people.add(person3);

        System.out.println("Розмір набору після додавання: " + people.size());  // 2
        System.out.println("Оновлений вміст набору: " + people);  // Дві особи
    }
}
