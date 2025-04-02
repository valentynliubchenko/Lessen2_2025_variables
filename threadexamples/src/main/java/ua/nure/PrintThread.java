package ua.nure;

class PrintThread extends Thread {
    private String message;
    private int delay;

    public PrintThread(String message, int delay) {
        this.message = message;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message + ": крок " + i);
            try {
                Thread.sleep(delay); // Пауза між виведеннями
            } catch (InterruptedException e) {
                System.out.println(message + " був перерваний");
                return;
            }
        }
        System.out.println(message + " завершив роботу");
    }
}
