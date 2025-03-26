package ua.nure;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();

        // Додавання елементів
        colors.add("Червоний");
        colors.add("Зелений");
        colors.add("Синій");
        colors.add("Зелений");  // Дублікат, не буде доданий

        for (String color : colors) {
            System.out.println(color);
        }

        // Розмір
        System.out.println("Кількість кольорів: " + colors.size());  // 3

        // Перевірка наявності
        System.out.println("Містить червоний: " + colors.contains("Червоний"));

        // Видалення
        colors.remove("Синій");

        // Перебір
        System.out.println("Усі кольори (порядок не гарантований):");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}