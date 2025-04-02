package ua.nure;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Створюємо потоки з різними пріоритетами
        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low Priority Thread: " + i);
                Thread.yield(); // Підказка планувальнику, що потік готовий поступитися
            }
        });

        Thread highPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High Priority Thread: " + i);
                Thread.yield();
            }
        });

        // Встановлюємо пріоритети
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        // Виводимо встановлені пріоритети
        System.out.println("Low priority thread priority: " + lowPriorityThread.getPriority());
        System.out.println("High priority thread priority: " + highPriorityThread.getPriority());

        // Запускаємо потоки
        lowPriorityThread.start();
        highPriorityThread.start();
        System.out.println("Exit");
    }
}