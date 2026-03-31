package ua.nure;

public class PriorityExample2 {
    public static void main(String[] args) {
        // Лічильники для відстеження кількості виконань
        final int[] highPriorityCounter = {0};
        final int[] lowPriorityCounter = {0};

        // Прапор для зупинки потоків через певний час
        final boolean[] running = {true};

        // Потік з високим пріоритетом для обробки критичних даних
        Thread dataProcessingThread = new Thread(() -> {
            while (running[0]) {
                processImportantData(highPriorityCounter);
                Thread.yield();
            }
            System.out.println("Високопріоритетний потік завершено. Всього виконань: " + highPriorityCounter[0]);
        });
        dataProcessingThread.setPriority(Thread.MAX_PRIORITY);
        dataProcessingThread.setName("High-Priority-Thread");

        // Потік з низьким пріоритетом для фонової обробки
        Thread backgroundJobThread = new Thread(() -> {
            while (running[0]) {
                doBackgroundTask(lowPriorityCounter);
                Thread.yield();
            }
            System.out.println("Низькопріоритетний потік завершено. Всього виконань: " + lowPriorityCounter[0]);
        });
        backgroundJobThread.setPriority(Thread.MIN_PRIORITY);
        backgroundJobThread.setName("Low-Priority-Thread");

        // Запуск потоків
        System.out.println("Запуск потоків...");
        dataProcessingThread.start();
        backgroundJobThread.start();

        // Дозволяємо потокам працювати протягом 5 секунд
        try {
            Thread.sleep(5000);

            // Виводимо проміжні результати кожну секунду
            for (int i = 0; i < 5; i++) {
                System.out.println("=== Статистика виконання ===");
                System.out.println("Високопріоритетний потік: " + highPriorityCounter[0] + " виконань");
                System.out.println("Низькопріоритетний потік: " + lowPriorityCounter[0] + " виконань");
                System.out.println("Співвідношення (високий/низький): " +
                        (double) highPriorityCounter[0] / Math.max(1, lowPriorityCounter[0]));

                Thread.sleep(1000);
            }

            // Зупиняємо потоки
            running[0] = false;

            // Чекаємо завершення потоків
            dataProcessingThread.join();
            backgroundJobThread.join();

            System.out.println("\n=== Фінальна статистика ===");
            System.out.println("Високопріоритетний потік: " + highPriorityCounter[0] + " виконань");
            System.out.println("Низькопріоритетний потік: " + lowPriorityCounter[0] + " виконань");
            System.out.println("Співвідношення (високий/низький): " +
                    (double) highPriorityCounter[0] / Math.max(1, lowPriorityCounter[0]));

        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано: " + e.getMessage());
        }

        System.out.println("Програму завершено");
    }

    private static void processImportantData(int[] counter) {
        // Обробка важливих даних
        counter[0]++;

        // Кожні 10000 виконань виводимо повідомлення
        if (counter[0] % 10000 == 0) {
            System.out.println("[Високий пріоритет] Оброблено важливих даних: " + counter[0]);
        }
    }

    private static void doBackgroundTask(int[] counter) {
        // Фонова робота
        counter[0]++;

        // Кожні 10000 виконань виводимо повідомлення
        if (counter[0] % 10000 == 0) {
            System.out.println("[Низький пріоритет] Виконано фонових задач: " + counter[0]);
        }
    }
}
