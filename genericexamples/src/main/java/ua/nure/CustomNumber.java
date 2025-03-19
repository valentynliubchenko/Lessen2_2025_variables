package ua.nure;

public class CustomNumber extends Number implements Comparable<CustomNumber> {

    private double value;

    public CustomNumber(double value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public int compareTo(CustomNumber other) {
        return Double.compare(this.value, other.value);
    }
}
