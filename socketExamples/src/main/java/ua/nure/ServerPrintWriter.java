package ua.nure;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPrintWriter {
    public static void main( String[] args ) {
        System.out.println( "Server is starting!" );
         {
            try (ServerSocket serverSocket = new ServerSocket(8082)){
                while ( true ) {
                    Socket socket = serverSocket.accept();

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello my friend !");

                    System.out.println("Server accepted!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
