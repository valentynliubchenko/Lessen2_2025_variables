package ua.nure;

public class DataProcessor<T extends Number & Comparable<T> > {
    private T[] data;
    public DataProcessor(T[] data) {
        this.data = data;
    }
    public T findMax() {
        if (data.length == 0) {
            return null;
        }
        T max = data[0];
        for (int i = 1; i < data.length; i++) {
            // Можемо використовувати compareTo, бо T реалізує Comparable
            if (data[i].compareTo(max) > 0) {
                max = data[i];
            }
        }
        return max;
    }
    public double average() {
        if (data.length == 0) {
            return 0;
        }
        double sum = 0;
        for (T value : data) {
            // Можемо використовувати doubleValue, бо T є підкласом Number
            sum += value.doubleValue();
        }

        return sum / data.length;
    }
}
