package ua.nure;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Встановлюємо потік як демон
        daemonThread.setDaemon(true);
        daemonThread.start();

        // Головний потік спить 3 секунди і завершується
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is ending");
        // Програма завершиться, хоча daemonThread має нескінченний цикл
    }
}