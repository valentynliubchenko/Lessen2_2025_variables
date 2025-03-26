package ua.nure;

import java.util.*;

public class SetUsageExample {
    public static void main(String[] args) {
        // Задача: аналіз слів у тексті
        String text = "Це приклад тексту для аналізу слів. " +
                "Цей текст містить повторення слів, " +
                "і ми будемо аналізувати слова у тексті.";

        // Розбиваємо на слова і перетворюємо на нижній регістр
        String[] words = text.toLowerCase()
                .replaceAll("[.,]", "")
                .split("\\s+");

        // 1. Унікальні слова (без сортування)
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Кількість унікальних слів: " + uniqueWords.size());

        // 2. Унікальні слова у порядку появи в тексті
        Set<String> wordsInOrder = new LinkedHashSet<>(Arrays.asList(words));
        System.out.println("\nСлова у порядку першої появи:");
        for (String word : wordsInOrder) {
            System.out.print(word + " ");
        }

        // 3. Унікальні слова в алфавітному порядку
        Set<String> sortedWords = new TreeSet<>(Arrays.asList(words));
        System.out.println("\n\nСлова в алфавітному порядку:");
        for (String word : sortedWords) {
            System.out.print(word + " ");
        }

        // 4. Знаходження спільних слів у двох текстах
        String text2 = "Це інший текст для порівняння слів. " +
                "Цей приклад містить нові слова.";
        String[] words2 = text2.toLowerCase()
                .replaceAll("[.,]", "")
                .split("\\s+");

        Set<String> uniqueWords2 = new HashSet<>(Arrays.asList(words2));

        // Копіюємо першу множину
        Set<String> commonWords = new HashSet<>(uniqueWords);
        // Залишаємо тільки спільні слова
        commonWords.retainAll(uniqueWords2);

        System.out.println("\n\nСпільні слова в обох текстах:");
        System.out.println(commonWords);

        // 5. Знаходження слів, які є тільки в першому тексті
        Set<String> uniqueToFirst = new HashSet<>(uniqueWords);
        uniqueToFirst.removeAll(uniqueWords2);

        System.out.println("\nСлова, унікальні для першого тексту:");
        System.out.println(uniqueToFirst);
    }
}
