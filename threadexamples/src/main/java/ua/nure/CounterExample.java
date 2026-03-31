package ua.nure;

public class CounterExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Створюємо два потоки, кожен збільшує лічильник на 1000
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Очікуваний результат: 2000
        System.out.println("Counter value: " + counter.getCount());
    }
}
