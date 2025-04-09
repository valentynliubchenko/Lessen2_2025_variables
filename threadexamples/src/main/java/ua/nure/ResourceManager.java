package ua.nure;

class ResourceManager {
    private int[] data = new int[10];
    private final Object readLock = new Object();
    private final Object writeLock = new Object();

    // Операція запису - використовує writeLock
    public void updateData(int index, int value) {
        synchronized(writeLock) {
            // Перевірка валідності індексу
            if (index >= 0 && index < data.length) {
                // Симулюємо тривалу операцію
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                data[index] = value;
                System.out.println("Дані оновлено: індекс " + index + ", значення " + value);
            }
        }
    }

    // Операція читання - використовує readLock
    public int readData(int index) {
        synchronized(readLock) {
            // Перевірка валідності індексу
            if (index >= 0 && index < data.length) {
                // Симулюємо операцію читання
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Дані прочитано: індекс " + index + ", значення " + data[index]);
                return data[index];
            }
            return -1; // Значення за замовчуванням для невалідного індексу
        }
    }

    // Операція, яка вимагає як читання, так і запису - використовує обидва блокування
    public void processData(int index) {
        // Важливо: спочатку отримуємо readLock, потім writeLock, щоб уникнути взаємного блокування
        synchronized(readLock) {
            synchronized(writeLock) {
                if (index >= 0 && index < data.length) {
                    int currentValue = data[index];
                    int newValue = currentValue * 2;
                    data[index] = newValue;
                    System.out.println("Дані оброблено: індекс " + index +
                            ", старе значення " + currentValue +
                            ", нове значення " + newValue);
                }
            }
        }
    }
}
