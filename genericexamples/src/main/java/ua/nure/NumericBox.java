package ua.nure;

public class NumericBox<T extends Number> {
    private T value;
    public NumericBox(T value) {
        this.value = value;
    }
    public double getDoubleValue() {
        return value.doubleValue();
    }
}
