package ua.nure;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AppFilesExample {
    public static void main(String[] args) {
        Path path = Path.of("example.txt");

        // Запис у файл
        try {
            String text = "Hello, Java NIO!";
            Files.write(path, text.getBytes(StandardCharsets.UTF_8)); // Записуємо байти в файл
            System.out.println("Дані записані в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Читання з файлу
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("Вміст файлу:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Перевірка, чи існує файл
        if (Files.exists(path)) {
            System.out.println("Файл існує.");
        }
    }
}
