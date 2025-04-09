package ua.nure;

public class BoundedBufferDemo {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();

        // Створюємо потік-виробник
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    buffer.put("Item-" + i);
                    System.out.println("Виробник додав: Item-" + i);

                    // Імітуємо роботу з різною швидкістю
                    Thread.sleep((long) (Math.random() * 10));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Потік виробника перервано");
            }
        });

        // Створюємо потік-споживач
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    Object item = buffer.take();
                    System.out.println("Споживач отримав: " + item);

                    // Імітуємо обробку з різною швидкістю
                    Thread.sleep((long) (Math.random() * 2000));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Потік споживача перервано");
            }
        });

        // Запускаємо потоки
        System.out.println("Запуск потоків виробника і споживача...");
        producer.start();
        consumer.start();

        // Чекаємо завершення потоків
        try {
            producer.join();
            consumer.join();
            System.out.println("Обидва потоки успішно завершили роботу");
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
            Thread.currentThread().interrupt();
        }
    }
}
