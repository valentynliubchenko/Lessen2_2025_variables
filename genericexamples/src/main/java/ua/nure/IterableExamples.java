package ua.nure;

import java.util.*;

public class IterableExamples {
    public static void main(String[] args) {
        // Приклад 1: Використання for-each циклу (неявне використання Iterable)
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        System.out.println("Приклад 1: Перебір через for-each цикл:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Приклад 2: Явне використання Iterator
        System.out.println("\nПриклад 2: Перебір через Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // Приклад 3: Використання методу forEach з Lambda (Java 8+)
        System.out.println("\nПриклад 3: Перебір через forEach з Lambda:");
        fruits.forEach(fruit -> System.out.println(fruit));

        // Приклад 4: Використання Iterator для модифікації колекції під час ітерації
        List<String> vegetables = new ArrayList<>(Arrays.asList("Carrot", "Potato", "Cucumber", "Tomato"));
        System.out.println("\nПриклад 4: Видалення елементів через Iterator:");
        System.out.println("Перед видаленням: " + vegetables);

        Iterator<String> vegIterator = vegetables.iterator();
        while (vegIterator.hasNext()) {
            String vegetable = vegIterator.next();
            if (vegetable.startsWith("C")) {
                vegIterator.remove(); // Безпечне видалення під час ітерації
            }
        }

        System.out.println("Після видалення: " + vegetables);

        // Приклад 5: Створення власного Iterable класу
        NumberRange range = new NumberRange(1, 5);
        System.out.println("\nПриклад 5: Власний Iterable клас:");
        for (Integer number : range) {
            System.out.println(number);
        }
    }
//
//    // Приклад власної реалізації Iterable
    static class NumberRange implements Iterable<Integer> {
        private final int start;
        private final int end;

        public NumberRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Iterator<Integer> iterator() {
            // Анонімний клас, що реалізує Iterator
            return new Iterator<Integer>() {
                private int current = start;

                @Override
                public boolean hasNext() {
                    return current <= end;
                }

                @Override
                public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return current++;
                }
            };
        }
    }
}