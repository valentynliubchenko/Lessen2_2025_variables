package ua.nure;

public class ThreadJoinExample {
    public static void main(String[] args) {
        System.out.println("Головний потік починає роботу");

        // Створюємо три потоки
        PrintThread thread1 = new PrintThread("Потік-1", 500);
        PrintThread thread2 = new PrintThread("Потік-2", 300);
        PrintThread thread3 = new PrintThread("Потік-3", 800);

        // Запускаємо потоки
        thread1.start();
        thread2.start();
        thread3.start();

        // Демонстрація без join()
        System.out.println("Без очікування завершення потоків (без join)");
        System.out.println("Головний потік продовжує виконання паралельно з іншими потоками");

        // Створюємо і запускаємо ще два потоки, але вже з join()
        PrintThread thread4 = new PrintThread("Потік-4", 500);
        PrintThread thread5 = new PrintThread("Потік-5", 700);

        thread4.start();

        System.out.println("Головний потік чекає завершення Потоку-4");
        try {
            // Очікуємо завершення thread4
            thread4.join();
            System.out.println("Потік-4 завершив роботу, головний потік продовжує виконання");

            thread5.start();
            // Очікуємо завершення thread5, але не більше 2 секунд
            thread5.join();
            if (thread5.isAlive()) {
                System.out.println("Час очікування Потоку-5 минув, але потік все ще працює");
            } else {
                System.out.println("Потік-5 завершив роботу протягом 2 секунд");
            }
        } catch (InterruptedException e) {
            System.out.println("Головний потік був перерваний");
            e.printStackTrace();
        }

        System.out.println("Головний потік завершує роботу");
    }
}

