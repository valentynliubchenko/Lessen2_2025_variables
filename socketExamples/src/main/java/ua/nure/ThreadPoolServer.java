package ua.nure;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ThreadPoolServer {
    public static void main(String[] args) throws IOException {
        // Створюємо пул потоків фіксованого розміру
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8089);

        System.out.println("Сервер з пулом потоків запущено на порту 8080");
        System.out.println("Розмір пулу: 10 потоків");

        try {
            while (true) {
                // Блокуюче очікування нового клієнта
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новий клієнт: " + clientSocket.getInetAddress());

                // Відправляємо завдання в пул потоків
                executor.submit(() -> {
                    try {
                        handleClient(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executor.shutdown();
            serverSocket.close();
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            // Інформація про потік, що обробляє клієнта
            out.println("Ваш запит обробляється потоком: " +
                    Thread.currentThread().getName());

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Отримано: " + inputLine);

                // Імітація обробки
                Thread.sleep(100);

                out.println("Відповідь від " + Thread.currentThread().getName() +
                        ": " + inputLine);

                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            socket.close();
            System.out.println("Клієнт відключився");
        }
    }
}
