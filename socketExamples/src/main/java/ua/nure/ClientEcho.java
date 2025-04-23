package ua.nure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientEcho {
    public static void main(String[] args) {
        int port = 8085;

        try (Socket socket = new Socket(InetAddress.getLocalHost(), port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server on port " + port);

            // Отримання вітального повідомлення від сервера
            String serverResponse = in.readLine();
            System.out.println("Server: " + serverResponse);

            String userInput;
            System.out.println("Enter messages (type 'STOP' to shut down the server, 'EXIT' to quit):");

            while (true) {
                System.out.print("> ");
                userInput = stdIn.readLine();

                if (userInput == null || "EXIT".equalsIgnoreCase(userInput.trim())) {
                    System.out.println("Exiting client...");
                    break;
                }

                // Відправка повідомлення на сервер
                out.println(userInput);

                // Отримання відповіді від сервера
                serverResponse = in.readLine();
                System.out.println("Server: " + serverResponse);

                // Якщо відправлено команду STOP, завершити після отримання відповіді
                if ("STOP".equalsIgnoreCase(userInput.trim())) {
                    System.out.println("Server shutdown initiated. Exiting client...");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
