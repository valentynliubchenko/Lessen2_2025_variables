package ua.nure;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // Використання як стек (LIFO - Last In, First Out)
        System.out.println("Використання як стек:");
        deque.push("Перший");
        deque.push("Другий");
        deque.push("Третій");

        while (!deque.isEmpty()) {
            System.out.println(deque.pop());  // Третій, Другий, Перший
        }

        // Використання як черга (FIFO - First In, First Out)
        System.out.println("\nВикористання як черга:");
        deque.offer("Перший");
        deque.offer("Другий");
        deque.offer("Третій");

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());  // Перший, Другий, Третій
        }

        // Додавання з обох кінців
        System.out.println("\nЗ обох кінців:");
        deque.addFirst("1");
        deque.addLast("2");
        deque.addFirst("0");
        deque.addLast("3");
        System.out.println(deque);  // [0, 1, 2, 3]

        // Отримання елементів без видалення
        System.out.println("Перший елемент: " + deque.getFirst());
        System.out.println("Останній елемент: " + deque.getLast());

        // Видалення елементів з обох кінців
        System.out.println("Видалено перший: " + deque.removeFirst());
        System.out.println("Видалено останній: " + deque.removeLast());
        System.out.println("Після видалення: " + deque);  // [1, 2]
    }
}
