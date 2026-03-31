package ua.nure;

import java.util.*;

public class CollectionsUtilExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 7, 5, 2));

        // Сортування
        Collections.sort(numbers);
        System.out.println("Відсортований список: " + numbers);

        // Зворотнє сортування
        Collections.reverse(numbers);
        System.out.println("Зворотній порядок: " + numbers);

        // Перемішування
        Collections.shuffle(numbers);
        System.out.println("Перемішаний список: " + numbers);

        // Мінімальне і максимальне значення
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Мін: " + min + ", Макс: " + max);

        // Бінарний пошук (працює тільки на відсортованих списках)
        Collections.sort(numbers);
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Індекс елемента 5: " + index);

        // Заповнення
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Collections.fill(list, "X");
        System.out.println("Заповнений список: " + list);

        // Частота елемента
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "apple");
        int frequency = Collections.frequency(words, "apple");
        System.out.println("Частота 'apple': " + frequency);

        // Незмінні колекції
        List<String> immutableList = Collections.unmodifiableList(
                new ArrayList<>(Arrays.asList("A", "B", "C"))
        );
        // immutableList.add("D");  // Викине UnsupportedOperationException

        // Синхронізовані колекції
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());

        // Порожні колекції
        List<Object> emptyList = Collections.emptyList();
        Set<Object> emptySet = Collections.emptySet();
        Map<Object, Object> emptyMap = Collections.emptyMap();
    }
}