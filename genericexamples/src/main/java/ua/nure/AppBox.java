package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppBox {

    public static void main(String[] args) {
        // Box для зберігання рядка
        Box<String> stringBox = new Box<String>("Hello, World!");
        String str = stringBox.getContent();
        log.info("str = {} ", str);
        System.out.println(str);  // Виведе: Hello, World!

        // Box для зберігання числа
        Box<Integer> intBox = new Box<>(42);
        int num = intBox.getContent();
        System.out.println(num);  // Виведе: 42
        log.info("num = {} ", num);
    }

}
