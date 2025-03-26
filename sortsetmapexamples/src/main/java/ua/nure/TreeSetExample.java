package ua.nure;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> fruits = new TreeSet<>();

        // Додавання елементів у довільному порядку
        fruits.add("Банан");
        fruits.add("Яблуко");
        fruits.add("Апельсин");
        fruits.add("Груша");

        // Елементи будуть автоматично відсортовані
        System.out.println("Відсортовані фрукти:");
        for (String fruit : fruits) {
            System.out.println(fruit);  // Апельсин, Банан, Груша, Яблуко
        }

        // Використання з власним класом (потрібно реалізувати Comparable)
        Set<Person> people = new TreeSet<>();
        people.add(new Person("Іван", "БПетров", 25));
        people.add(new Person("Марія", "Коваленко", 30));
        people.add(new Person("Петро", "АІваненко", 20));

        System.out.println("\nВідсортовані люди (за прізвищем):");
        for (Person person : people) {
            System.out.println(person);
        }

        // Використання NavigableSet методів
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.addAll(Set.of(5, 11, 15, 20, 25, 30));

        System.out.println("\nЧисла менші за 20: " + numbers.headSet(20));
        System.out.println("Числа більші або рівні 20: " + numbers.tailSet(20));
        System.out.println("Перше число: " + numbers.first());
        System.out.println("Останнє число: " + numbers.last());
        System.out.println("Найближче менше за 13: " + numbers.lower(13));  // 10
        System.out.println("Найближче більше або рівне 13: "
                + numbers.ceiling(13));  // 15
    }

    static class Person implements Comparable<Person> {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            return this.lastName.compareTo(other.lastName);
        }

        @Override
        public String toString() {
            return lastName + " " + firstName + " (" + age + " років)";
        }
    }
}