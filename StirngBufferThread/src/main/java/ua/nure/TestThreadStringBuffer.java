package ua.nure;

public class TestThreadStringBuffer extends Thread {
    static StringBuffer sbr = new StringBuffer();  // Потокобезпечний StringBuffer

    public void run() {
        for (int i = 0; i < 1000; i++) {
            sbr.append("Hello ");
            System.out.println("Thread " + Thread.currentThread().getId() + " is changed sbr: " + sbr.toString());
        }
    }
}
