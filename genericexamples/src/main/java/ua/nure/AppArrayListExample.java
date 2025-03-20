package ua.nure;

import java.util.ArrayList;
import java.util.List;

public class AppArrayListExample {
    public static void main(String[] args) {
        // Створення ArrayList
        List<String> fruits = new ArrayList<>();
        // Додавання елементів
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        // Доступ за індексом
        System.out.println("Перший фрукт: " + fruits.get(0));
        // Зміна елемента
        fruits.set(1, "Mango");
        // Видалення елемента
        fruits.remove(2);
        // Перевірка наявності
        boolean hasApple = fruits.contains("Apple");
        System.out.println("Містить яблуко: " + hasApple);
        // Розмір
        System.out.println("Кількість фруктів: " + fruits.size());
        // Перебір елементів
        System.out.println("Всі фрукти:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}