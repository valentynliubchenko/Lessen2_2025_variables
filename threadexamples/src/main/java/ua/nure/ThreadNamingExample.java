package ua.nure;

public class ThreadNamingExample {
    public static void main(String[] args) {
        // Отримання та зміна імені поточного потоку
        Thread currentThread = Thread.currentThread();
        System.out.println("Default main thread name: " + currentThread.getName());
        currentThread.setName("MainControlThread");
        System.out.println("New main thread name: " + currentThread.getName());

        // Створення потоків з іменами через конструктор
        Thread thread1 = new Thread(() -> {
            System.out.println("Running in thread: " + Thread.currentThread().getName());
        }, "WorkerThread-1");

        // Створення та перейменування потоку
        Thread thread2 = new Thread(() -> {
            System.out.println("Running in thread: " + Thread.currentThread().getName());
        });
        thread2.setName("WorkerThread-2");

        thread1.start();
        thread2.start();
    }
}