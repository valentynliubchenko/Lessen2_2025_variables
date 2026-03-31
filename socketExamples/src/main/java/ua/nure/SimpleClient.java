package ua.nure;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        try (
                // Підключаємося до сервера на localhost:8080
                Socket socket = new Socket("localhost", 8089);

                // Потоки для відправки та отримання даних
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                // Сканер для читання введення користувача
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Підключено до сервера. Введіть повідомлення:");
            System.out.println("Для виходу введіть 'exit'");

            String userInput;
            while (true) {
                // Запитуємо користувача ввести повідомлення
                System.out.print("> ");
                userInput = scanner.nextLine();

                // Відправляємо повідомлення на сервер
                out.println(userInput);

                // Отримуємо відповідь від сервера
                String response = in.readLine();
                System.out.println("Відповідь сервера: " + response);

                // Перевіряємо умову виходу
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
            }

            System.out.println("З'єднання закрито");

        } catch (UnknownHostException e) {
            System.err.println("Невідомий хост: localhost");
        } catch (IOException e) {
            System.err.println("Помилка вводу-виводу при роботі з сервером");
            e.printStackTrace();
        }
    }
}



