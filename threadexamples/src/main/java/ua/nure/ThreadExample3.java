package ua.nure;

public class ThreadExample3 {
    public static void main(String[] args) {
        // Створення потоку з використанням лямбда-виразу (Java 8+)
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Лямбда-потік: " + i + " "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаємо потік
        thread.start();

        // Код в головному потоці
        for (int i = 0; i < 5; i++) {
            System.out.println("Головний потік: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit");
    }
}
