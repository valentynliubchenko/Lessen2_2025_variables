package ua.nure;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPrintStream {
    public static void main( String[] args ) {
        System.out.println( "Server is starting!" );
         {
            try (ServerSocket serverSocket = new ServerSocket(8082)){
                while ( true ) {
                    Socket socket = serverSocket.accept();

                    PrintStream out = new PrintStream(socket.getOutputStream(), true);
                    out.println("Hello my friend !  Привіт !");
                    out.flush();
                    System.out.println("Server accepted!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
