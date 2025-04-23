package ua.nure;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDataInputStream {
    public static void main(String[] args) {
        System.out.println("Server is starting!");
        {
            try (ServerSocket serverSocket = new ServerSocket(8082)) {
                Socket socket = serverSocket.accept();

                DataInputStream  dis = new DataInputStream(socket.getInputStream());
                float receivedInt = dis.readFloat();

                System.out.println("Server received: " + receivedInt);

                System.out.println("Server accepted!");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
