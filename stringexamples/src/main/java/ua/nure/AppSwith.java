package ua.nure;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AppSwith {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введіть своє ім'я:");
        String name = reader.readLine();

        System.out.println("Введіть свій вік:");
        String ageStr = reader.readLine();
        int age = Integer.parseInt(ageStr);

        System.out.println("Привіт, " + name + "! Тобі " + age + " років.");

        reader.close(); // Закриваємо BufferedReader після використання
    }
}
