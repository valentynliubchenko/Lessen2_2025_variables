package ua.nure;

import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8087);
        System.out.println("Сервер запущено на порту 8080");

        while (true) {
            // Блокуюче очікування нового клієнта
            Socket clientSocket = serverSocket.accept();
            System.out.println("Новий клієнт: " + clientSocket.getInetAddress());

            // Створюємо новий потік для обробки клієнта
            new Thread(() -> {
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Отримано: " + inputLine);
                out.println("Ехо: " + inputLine);

                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;
                }
            }
        } finally {
            socket.close();
            System.out.println("Клієнт відключився");
        }
    }
}