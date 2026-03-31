package ua.nure;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBasic2 {
    public static void main( String[] args ) {
        System.out.println( "Server is starting!" );

        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Socket socket = serverSocket.accept();
            System.out.println( "Server accepted!" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
