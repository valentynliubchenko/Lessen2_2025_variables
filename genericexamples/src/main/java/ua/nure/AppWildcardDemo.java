package ua.nure;

import java.util.ArrayList;
import java.util.List;

public class AppWildcardDemo {
    public static void main(String[] args) {
        // Приклад з Upper Bounded Wildcard
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        List<Double> doubles = new ArrayList<>();
        doubles.add(10.5);
        doubles.add(20.5);
        doubles.add(30.5);

        System.out.println("Сума цілих чисел: " + sum(integers));  // 60.0
        System.out.println("Сума дробових чисел: " + sum(doubles));  // 61.5

        // Приклад з Lower Bounded Wildcard
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("Після додавання цілих чисел: " + numbers);  // [1, 2, 3]

        List<Object> objects = new ArrayList<>();
        addIntegers(objects);
        System.out.println("Після додавання цілих чисел до об'єктів: " + objects);  // [1, 2, 3]
    }

    // Upper Bounded Wildcard - можемо читати елементи як Number
    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    // Lower Bounded Wildcard - можемо додавати Integer або його суперкласи
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}
