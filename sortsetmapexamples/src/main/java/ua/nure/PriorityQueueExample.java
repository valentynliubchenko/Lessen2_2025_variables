package ua.nure;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Створення пріоритетної черги (за замовчуванням - натуральний порядок)
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        // Додавання елементів
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);

        // Отримання першого елемента (з найвищим пріоритетом)
        System.out.println("Перший елемент: " + priorityQueue.peek());  // 5

        // Видалення та отримання елементів за пріоритетом
        System.out.println("Елементи за пріоритетом:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

//        // Пріоритетна черга з власним компаратором
//        //(сортування за довжиною в зворотньому порядку)
        Queue<String> stringQueue =
                new PriorityQueue<>((s1, s2) -> s2.length() - s1.length());

        stringQueue.add("БЯблуко");
        stringQueue.add("Грушка3");
        stringQueue.add("Апельсин");

        System.out.println("Слова за довжиною (від найдовшого):");
        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.poll());
        }

        // Використання з власним класом
        Queue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task("Відправити звіт", 3));
        taskQueue.add(new Task("Виправити помилку", 1));
        taskQueue.add(new Task("Оновити документацію", 2));

        System.out.println("\nЗавдання за пріоритетом:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }

    // Клас Task з реалізацією Comparable
    static class Task implements Comparable<Task> {
        private String description;
        private int priority;  // Менше число = вищий пріоритет

        public Task(String description, int priority) {
            this.description = description;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            // Сортування за пріоритетом (менше число = вищий пріоритет)
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "[Пріоритет " + priority + "] " + description;
        }
    }
}