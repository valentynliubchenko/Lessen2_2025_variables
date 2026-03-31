package ua.nure;

class MyThread extends Thread {
    @Override
    public void run() {
        // Цей метод буде виконуватись в окремому потоці
        for (int i = 0; i < 10; i++) {
            System.out.println("Дочірній потік: " + i +" " +getName());
            try {
                Thread.sleep(1500); // Затримка на 1.5 секунди
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}