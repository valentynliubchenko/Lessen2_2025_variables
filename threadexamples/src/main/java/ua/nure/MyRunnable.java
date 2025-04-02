package ua.nure;

public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Потік Runnable: " + i+ " "+Thread.currentThread().getName());
//            try {
//             //   Thread.sleep(1500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
