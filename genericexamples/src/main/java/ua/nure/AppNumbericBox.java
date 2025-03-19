package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppNumbericBox {
    public static void main(String[] args) {
        NumericBox<Integer> intBox = new NumericBox<>(10);
        System.out.println(intBox.getDoubleValue()); // 10.0
        NumericBox<Double> doubleBox = new NumericBox<>(10.5);
        System.out.println(doubleBox.getDoubleValue()); // 10.5
        // Помилка компіляції - String не є підтипом Number
//        NumericBox<String> stringBox = new NumericBox<>("test");
    }
}
