package ua.nure;

public class ProducerConsumerExample {
    // Головний метод програми, точка входу
    public static void main(String[] args) {
// Створюємо спільний буфер розміром 5 елементів
        MyQueue queue = new MyQueue(5);

// Створюємо потік-виробник
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);// Імітація роботи
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

// Створюємо потік-споживач
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int value = queue.get();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(200);// Імітація роботи
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

// Запускаємо обидва потоки
        producer.start();
        consumer.start();
    }
}