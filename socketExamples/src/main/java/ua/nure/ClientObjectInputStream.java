package ua.nure;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientObjectInputStream {
    public static void main(String[] args) {
        int port =8082;
        Person person = new Person("Микола", 22);

        System.out.println( "Client is starting..." );
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            socket.setSoTimeout(1000);
            System.out.println( "Client is connected to " + socket.getRemoteSocketAddress() + "port " + socket.getPort() );

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            out.writeObject(person);
            out.flush();


            System.out.println( "sent data person : " + person.toString() );
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
