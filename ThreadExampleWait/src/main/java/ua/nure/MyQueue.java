package ua.nure;

class MyQueue {
    private final int[] data;// Масив для зберігання даних
    private int putIndex = 0;// Індекс для додавання нового елемента
    private int getIndex = 0;// Індекс для отримання наступного елемента
    private int count = 0;// Кількість елементів у черзі

    // Конструктор, приймає розмір буфера
    public MyQueue (int size) {
        data = new int[size];
    }

    // Метод для додавання елемента в чергу
    public synchronized void put(int value) throws InterruptedException {
// Чекаємо, поки звільниться місце
        while (count == data.length) {
            wait();// Звільняє монітор і призупиняє потік
        }
// Додавання елемента
        data[putIndex] = value;
// Оновлення індексу (циклічно)
        putIndex = (putIndex + 1) % data.length;
// Збільшення лічильника елементів
        count++;
// Повідомляємо всі очікуючі потоки
        notifyAll();
    }

    // Метод для отримання елемента з черги
    public synchronized int get() throws InterruptedException {
// Чекаємо, поки будуть дані
        while (count == 0) {
            wait();// Звільняє монітор і призупиняє потік
        }
// Отримання елемента
        int value = data[getIndex];
// Оновлення індексу (циклічно)
        getIndex = (getIndex + 1) % data.length;
// Зменшення лічильника елементів
        count--;
// Повідомляємо всі очікуючі потоки
        notifyAll();
        return value;
    }
}