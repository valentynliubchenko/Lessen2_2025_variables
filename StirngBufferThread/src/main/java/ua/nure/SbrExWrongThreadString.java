package ua.nure;

public class SbrExWrongThreadString {
    public static void main(String args[]) throws InterruptedException {
        TestWrongThreadString thread1 = new TestWrongThreadString();
        TestWrongThreadString thread2 = new TestWrongThreadString();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(TestWrongThreadString.sbr);
        System.out.println(" (Words count: " + TestWrongThreadString.sbr.trim().split("\\s+").length + ")");

    }
}
