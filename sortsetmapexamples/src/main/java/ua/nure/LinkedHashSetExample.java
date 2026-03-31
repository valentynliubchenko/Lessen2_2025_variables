package ua.nure;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> cities = new TreeSet<>();

        // Додавання елементів
        cities.add("Київ");
        cities.add("Львів");
        cities.add("Одеса");
        cities.add("Харків");

        // Перебір (порядок додавання зберігається)
        System.out.println("Міста в порядку додавання:");
        for (String city : cities) {
            System.out.println(city);
        }

        // Видалення і додавання
        cities.remove("Одеса");
        cities.add("Дніпро");  // Додасться в кінець

        System.out.println("\nМіста після змін:");
        for (String city : cities) {
            System.out.println(city);  // Київ, Львів, Харків, Дніпро
        }
    }
}
