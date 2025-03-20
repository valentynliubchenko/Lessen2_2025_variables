package ua.nure;

import java.util.LinkedList;
import java.util.List;

public class AppLinkedList {
    public static void main(String[] args) {
        // Використовуємо інтерфейс List замість конкретної реалізації Linked
        LinkedList<String> linkedAnimals = new LinkedList<>();
        // Додавання елементів
        linkedAnimals.add("Лев");
        linkedAnimals.add("Тигр");
        linkedAnimals.add("Вовк");

        // Для використання специфічних методів
        // LinkedList потрібно привести до типу LinkedList
//        LinkedList<String> linkedAnimals = (LinkedList<String>)animals;

        // Додавання на початок/кінець (специфічні методи LinkedList)
        linkedAnimals.addFirst("Слон");
        linkedAnimals.addLast("Жираф");

        // Отримання першого/останнього елемента
        System.out.println("Перший: " + linkedAnimals.getFirst());
        System.out.println("Останній: " + linkedAnimals.getLast());

        // Використання як черги/стека
        linkedAnimals.poll(); // Видаляє перший елемент
        linkedAnimals.push("Ведмідь"); // Додає на початок
        linkedAnimals.pop(); // Видаляє та повертає перший елемент

        System.out.println("Усі тварини:");
        for (String animal : linkedAnimals) {
            System.out.println(animal);
        }
    }
}
