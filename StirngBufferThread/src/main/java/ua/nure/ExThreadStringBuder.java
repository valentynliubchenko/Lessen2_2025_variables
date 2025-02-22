package ua.nure;

public class ExThreadStringBuder {
    public static void main(String args[]) throws InterruptedException {
        TestThreadStringBuffer thread1 = new TestThreadStringBuffer();
        TestThreadStringBuffer thread2 = new TestThreadStringBuffer();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(TestThreadStringBuffer.sbr);
        System.out.println(" (Words count: " + TestThreadStringBuffer.sbr.toString().trim().split("\\s+").length + ")");
        System.out.printf("Привет %d   xfsfdsd%f", 20, 45.6);

    }
}
