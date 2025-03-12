package ua.nure;

public record MyPoint(int x, int y) {

    @Override
    public String toString() {
        return String.format("my string: x = %d  y = %d" , x, y );
    }
    public static MyPoint create(){
        return new MyPoint(100, 100);
    }
}
