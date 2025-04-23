package ua.nure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {
    public static void main(String[] args) {
        System.out.println("Server is starting...");
        int port = 8085;
        boolean running = true;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for clients...");

            while (running) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                    out.println("Welcome to the server! Send 'STOP' to shut down the server.");

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received from client: " + inputLine);

                        // Перевірка на команду зупинки
                        if ("STOP".equalsIgnoreCase(inputLine.trim())) {
                            out.println("Server is shutting down...");
                            System.out.println("Received STOP command. Shutting down server...");
                            running = false;
                            break;
                        }

                        // Ехо-відповідь клієнту
                        String response = "Echo: " + inputLine;
                        out.println(response);
                        System.out.println("Sent to client: " + response);
                    }
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port + ": " + e.getMessage());
        }

        System.out.println("Server has been shut down.");
    }
}
