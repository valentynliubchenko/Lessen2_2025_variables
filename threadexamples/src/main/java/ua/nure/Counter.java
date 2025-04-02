package ua.nure;

class Counter {
    private int count = 0;

    private final Object lock = new Object();

    // 1 варіант
//    public synchronized void increment() {
//        count++;  // Неатомарна операція
//    }
//
//    public synchronized int getCount() {
//        return count;
//    }

    //2 варіант
    public void increment() {

        synchronized (lock) {
            count++;  // Неатомарна операція
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }


// не синхронізовані
//    public void increment() {
//        count++;  // Неатомарна операція
//    }
//
//    public int getCount() {
//        return count;
//    }

}