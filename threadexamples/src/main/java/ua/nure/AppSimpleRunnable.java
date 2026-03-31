package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppSimpleRunnable
{
    public static void main( String[] args )
    {
        log.info( "Hello World! {} {}", 232, 2.5 );

        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

// 3. Запуск потоку
        t.start();
        t2.start();
        t3.start();
        System.out.println("Exit");
    }
}
