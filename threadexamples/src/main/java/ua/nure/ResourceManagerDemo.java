package ua.nure;

public class ResourceManagerDemo {
    public static void main(String[] args) {
        // Створюємо екземпляр менеджера ресурсів
        ResourceManager resourceManager = new ResourceManager();

        // Ініціалізуємо дані
        for (int i = 0; i < 5; i++) {
            resourceManager.updateData(i, i * 10);
        }

        // Створюємо поток для операцій читання
        Thread readerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resourceManager.readData(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Створюємо поток для операцій запису
        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resourceManager.updateData(i, i * 20);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Створюємо поток для комплексної обробки
        Thread processorThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resourceManager.processData(i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Запускаємо потоки
        System.out.println("Запускаємо потоки...");
        readerThread.start();
        writerThread.start();
        processorThread.start();

        // Чекаємо завершення потоків
        try {
            readerThread.join();
            writerThread.join();
            processorThread.join();
        } catch (InterruptedException e) {
            System.out.println("Головний поток було перервано");
            Thread.currentThread().interrupt();
        }

        System.out.println("Всі потоки завершили виконання!");
    }
}