package ua.nure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientReaderUTF8 {
    public static void main(String[] args) {
        int port =8082;

        System.out.println( "Client is starting..." );
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            socket.setSoTimeout(1000);
            System.out.println( "Client is connected to " + socket.getRemoteSocketAddress() + "port " + socket.getPort() );

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            String inputLine = bufferedReader.readLine();
            System.out.println( "Server received: " + inputLine );
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
