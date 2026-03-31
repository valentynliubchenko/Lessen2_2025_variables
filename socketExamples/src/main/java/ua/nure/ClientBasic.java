package ua.nure;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientBasic {
    public static void main(String[] args) {
        int port =8081;

        System.out.println( "Client is starting..." );
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            socket.setSoTimeout(1000);
            System.out.println( "Client is connected to " + socket.getRemoteSocketAddress() + "port " + socket.getPort() );
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
