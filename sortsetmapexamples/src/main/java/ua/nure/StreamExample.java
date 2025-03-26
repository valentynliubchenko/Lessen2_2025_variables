package ua.nure;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Іван", "Марія", "Петро", "Ірина", "Іван");

        // Фільтрація
        List<String> namesStartingWithI = names.stream()
                .filter(name -> name.startsWith("І"))
                .collect(Collectors.toList());
        System.out.println("Імена на літеру І: " + namesStartingWithI);

        // Відображення
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Довжини імен: " + nameLengths);

        // Унікальні елементи
        List<String> uniqueNames = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Унікальні імена: " + uniqueNames);

        // Сортування
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Відсортовані імена: " + sortedNames);

        // Агрегація
        long count = names.stream().count();
        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("Кількість імен: " + count);
        System.out.println("Сумарна довжина всіх імен: " + totalLength);

        // Групування
        Map<Integer, List<String>> namesByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Імена за довжиною: " + namesByLength);

        // Об'єднання в рядок
        String joinedNames = names.stream()
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Імена через кому: " + joinedNames);

        // Перевірка умов
        boolean allStartWithI = names.stream().allMatch(name -> name.startsWith("І"));
        boolean anyStartsWithP = names.stream().anyMatch(name -> name.startsWith("П"));
        System.out.println("Всі на І: " + allStartWithI);
        System.out.println("Хоча б одне на П: " + anyStartsWithP);
    }
}
