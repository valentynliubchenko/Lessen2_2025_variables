package ua.nure;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Запуск задачі з затримкою 3 секунди
        scheduler.schedule(() -> {
            System.out.println("Одноразова задача з затримкою");
        }, 300, TimeUnit.MILLISECONDS);

        // Запуск задачі з затримкою 1 секунда і повторенням кожні 2 секунди
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Періодична задача: " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // Зупинити планувальник через 10 секунд
        try {
            Thread.sleep(10000);
            scheduler.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
