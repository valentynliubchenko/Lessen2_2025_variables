package ua.nure;

public class ResourceManagerDemo {
    public static void main(String[] args) {
        // Створюємо спільний екземпляр ResourceManager
        ResourceManager resourceManager = new ResourceManager();

        // Створюємо кілька потоків, які конкурують за ресурс
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resourceManager.performTask();
                try {
                    Thread.sleep(1000); // пауза між спробами
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourceManager.performTimedTask();
                try {
                    Thread.sleep(1000); // інша пауза для різноманіття
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-2");

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourceManager.performTimedTask();
                try {
                    Thread.sleep(1000); // ще інша пауза
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-3");

        // Запускаємо потоки
        System.out.println("Запуск потоків для демонстрації tryLock...");
        thread1.start();
        thread2.start();
        thread3.start();

        // Чекаємо завершення всіх потоків
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("Всі потоки завершили роботу");
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
            Thread.currentThread().interrupt();
        }
    }
}