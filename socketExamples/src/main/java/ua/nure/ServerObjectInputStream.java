package ua.nure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerObjectInputStream {
    public static void main(String[] args) {
        System.out.println("Server is starting!");
        {
            try {
                ServerSocket serverSocket = new ServerSocket(8082);
                while (true) {
                    try {

                        Socket socket = serverSocket.accept();
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                        Object receivedObject = ois.readObject();
                        if (receivedObject instanceof Person) {
                            Person person = (Person) receivedObject;
                            System.out.println("Receive person:" + person);
                        } else {
                            System.out.println("Received object is not of type Person");
                        }


                    } catch (ClassNotFoundException e) {
                        System.out.println("Class not found");
                        //throw new RuntimeException(e);
                    } catch (StreamCorruptedException e) {
                        System.out.println("Class StreamCorruptedException ");
                        //throw new RuntimeException(e);
                    } catch (IOException e) {
                        System.out.println("Class IOException");
                        //throw new RuntimeException(e);
                    }
                }

                //System.out.println("Server accepted!");

            } catch (IOException e) {
                System.out.println("Class not found 3");
                throw new RuntimeException(e);
            }
        }
    }
}
