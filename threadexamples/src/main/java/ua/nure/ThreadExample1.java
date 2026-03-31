package ua.nure;

public class ThreadExample1 {
    public static void main(String[] args) throws InterruptedException {
        // Створюємо екземпляр нашого потоку
        MyThread thread = new MyThread();

        // Запускаємо потік
        thread.start();

        // Код в головному потоці продовжує виконуватись
        for (int i = 0; i < 5; i++) {
            System.out.println("Головний потік: " + i);
            try {
                Thread.sleep(1000); // Затримка на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        thread.join();

        System.out.println("Exit");
    }
}
