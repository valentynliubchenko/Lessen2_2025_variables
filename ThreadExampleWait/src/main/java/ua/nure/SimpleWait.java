package ua.nure;

public class SimpleWait {

    private boolean messageReady = false;
    private String message;

    public synchronized void sendMessage(String message) {
        messageReady = true;
        this.message = message;
        notifyAll();
    }

    public synchronized String receiveMessage() throws InterruptedException {
        while (!messageReady) {
            wait();
        }
        messageReady = false;
        return message;
    }

    public static void main(String[] args) {
        SimpleWait wait = new SimpleWait();

        Thread consumer = new Thread(() -> {
            System.out.println("Consumer thread started");
            try {
                String receiveMessage = wait.receiveMessage();
                System.out.println(receiveMessage);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumerthread finished");
        }
        );

        Thread producer = new Thread(() -> {
            System.out.println("Producer thread started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            wait.sendMessage("Hello Consumer");
        });

        consumer.start();
        producer.start();

    }

}
