package ua.nure;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        // Створює нові потоки за потреби, повторно використовує неактивні
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Виконання задачі #" + taskId +
                        " в потоці " + Thread.currentThread().getName());
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}