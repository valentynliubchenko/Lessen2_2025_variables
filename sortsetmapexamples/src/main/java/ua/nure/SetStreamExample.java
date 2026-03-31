package ua.nure;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.TreeSet;

public class SetStreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "яблуко", "банан", "апельсин", "яблуко", "груша",
                "банан", "ківі", "манго", "апельсин"
        );

        // Отримання унікальних елементів
        Set<String> uniqueWords = words.stream()
                .collect(Collectors.toSet());

        System.out.println("Унікальні слова: " + uniqueWords);

        // Отримання відсортованих унікальних елементів
        Object TreeSet;
        Set<String> sortedUniqueWords = words.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Відсортовані унікальні слова: " + sortedUniqueWords);

        // Фільтрація, мапування та збір у Set
        Set<String> filteredWords = words.stream()
                .filter(w -> w.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println("Відфільтровані слова: " + filteredWords);

        // Перетворення елементів List у Set з власним обробником
        Set<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Унікальні довжини слів (відсортовані): " + wordLengths);
    }
}