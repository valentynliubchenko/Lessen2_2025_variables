package ua.nure;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ResourceManager {
    private final Lock resourceLock = new ReentrantLock();

    public void performTask() {
        boolean lockAcquired = false;
        try {
            // Спроба отримати блокування без очікування
            lockAcquired = resourceLock.tryLock();

            if (lockAcquired) {
                // Блокування отримано, виконуємо основну роботу
                System.out.println("Блокування отримано, виконуємо завдання");
                // ... робота з ресурсом ...
            } else {
                // Блокування не отримано, виконуємо альтернативну логіку
                System.out.println("Блокування не отримано, виконуємо альтернативне завдання");
                // ... альтернативна логіка ...
            }
        } finally {
            // Розблоковуємо тільки якщо блокування було отримано
            if (lockAcquired) {
                resourceLock.unlock();
            }
        }
    }

    public void performTimedTask() {
        boolean lockAcquired = false;
        try {
            // Спроба отримати блокування з таймаутом
            lockAcquired = resourceLock.tryLock(10, TimeUnit.MICROSECONDS);

            if (lockAcquired) {
                System.out.println("Блокування отримано протягом вказаного часу");
                // ... робота з ресурсом ...
            } else {
                System.out.println("Не вдалося отримати блокування за 2 секунди");
            }
        } catch (InterruptedException e) {
            System.out.println("Потік перервано під час очікування блокування");
            Thread.currentThread().interrupt();
        } finally {
            if (lockAcquired) {
                resourceLock.unlock();
            }
        }
    }
}