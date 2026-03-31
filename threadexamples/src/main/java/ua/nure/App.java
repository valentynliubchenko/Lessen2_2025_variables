package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App
{
    public static void main( String[] args ) {
        log.info( "Hello World! {} {}", 232, 2.5 );

        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

// 3. Запуск потоку
        t.start();
        t2.start();
        t3.start();

        try {
            t.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Exit");
    }
}
