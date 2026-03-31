package ua.nure;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[100];
    private int putIndex = 0, takeIndex = 0, count = 0;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();  // Чекаємо, поки буфер не стане не повним
            }
            items[putIndex] = x;
            putIndex = (putIndex + 1) % items.length;
            count++;
            notEmpty.signal();  // Сигналізуємо потокам, що чекають на непорожній буфер
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();  // Чекаємо, поки буфер не стане непорожнім
            }
            Object x = items[takeIndex];
            takeIndex = (takeIndex + 1) % items.length;
            count--;
            notFull.signal();  // Сигналізуємо потокам, що чекають на неповний буфер
            return x;
        } finally {
            lock.unlock();
        }
    }
}