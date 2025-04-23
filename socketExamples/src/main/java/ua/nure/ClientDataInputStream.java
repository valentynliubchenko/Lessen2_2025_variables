package ua.nure;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDataInputStream {
    public static void main(String[] args) {
        int port =8082;

        System.out.println( "Client is starting..." );
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            socket.setSoTimeout(1000);
            System.out.println( "Client is connected to " + socket.getRemoteSocketAddress() + "port " + socket.getPort() );

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            float dataint = 123.45f;
            out.writeFloat(dataint);

            System.out.println( "sent data int: " + dataint );
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
