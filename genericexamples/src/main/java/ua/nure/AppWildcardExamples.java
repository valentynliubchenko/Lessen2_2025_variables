package ua.nure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppWildcardExamples {
    public static void main(String[] args) {
        // Створюємо різні списки
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        // Демонстрація Upper Bounded Wildcard
        System.out.println("Сума integers: " + sumList(integers));
        System.out.println("Сума doubles: " + sumList(doubles));
        System.out.println("Максимальне з integers: " + findMax(integers));
        System.out.println("Максимальне з doubles: " + findMax(doubles));
        List<String> strings = Arrays.asList("one", "two", "three");
        //findMax(strings); // Помилка! String не є підкласом Number
        // Копіюємо елементи використовуючи Upper Bounded Wildcard
        copyElements(integers, numbers);
        System.out.println("Скопійовані integers в numbers: " + numbers);
        // Демонстрація Lower Bounded Wildcard
        fillWithIntegers(numbers);
        System.out.println("Numbers після додавання: " + numbers);
        fillWithIntegers(objects);
        System.out.println("Objects після додавання: " + objects);
        // Це не скомпілюється:
        // fillWithIntegers(doubles); // Помилка! List<Double> не є List<? super Integer >
    }

    // Upper Bounded Wildcard - отримуємо елементи для підрахунку суми
    public static double sumList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    // Upper Bounded Wildcard з додатковим обмеженням Comparable
    public static <T extends Number & Comparable<? super T>> T findMax(List
                                                                               <T> list) {
        if (list.isEmpty()) {
            return null;
        }
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    // Комбінація Upper і Lower Bounded Wildcards
    public static <T> void copyElements(List<? extends T> source, List<? super
            T> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }

    // Lower Bounded Wildcard - додаємо Integer в список, що може містити
//    Integer або    його суперкласи

    public static void fillWithIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }

}
