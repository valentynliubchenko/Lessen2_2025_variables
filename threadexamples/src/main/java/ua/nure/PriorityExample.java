package ua.nure;

public class PriorityExample {
    public static void main(String[] args) {
        // Потік з високим пріоритетом для обробки критичних даних
        Thread dataProcessingThread = new Thread(() -> {
            while (true) {
                processImportantData();
                Thread.yield();
            }
        });
        dataProcessingThread.setPriority(Thread.MAX_PRIORITY);

        // Потік з низьким пріоритетом для фонової обробки
        Thread backgroundJobThread = new Thread(() -> {
            while (true) {
                doBackgroundTask();
                Thread.yield();
            }
        });
        backgroundJobThread.setPriority(Thread.MIN_PRIORITY);

        // Запуск потоків
        dataProcessingThread.start();
        backgroundJobThread.start();
    }

    private static void processImportantData() {
        System.out.println("processImportantData");
    }

    private static void doBackgroundTask() {
        System.out.println("doBackgroundTask");
    }
}