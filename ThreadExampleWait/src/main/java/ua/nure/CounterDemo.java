package ua.nure;

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        // Створюємо спільний екземпляр лічильника
        Counter counter = new Counter();

        // Кількість потоків і операцій для тестування
        int numThreads = 5;
        int incrementsPerThread = 1000;

        // Створюємо і запускаємо кілька потоків для інкрементування лічильника
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
                System.out.println(Thread.currentThread().getName() +
                        " завершив роботу, поточне значення: " +
                        counter.getCount());
            }, "Thread-" + i);

            threads[i].start();
        }

        // Чекаємо завершення всіх потоків
        for (Thread thread : threads) {
            thread.join();
        }

        // Перевіряємо кінцеве значення лічильника
        System.out.println("Всі потоки завершили роботу.");
        System.out.println("Очікуване значення: " + (numThreads * incrementsPerThread));
        System.out.println("Фактичне значення: " + counter.getCount());
    }
}