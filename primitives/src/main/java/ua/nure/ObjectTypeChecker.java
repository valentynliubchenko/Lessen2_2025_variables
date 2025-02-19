package ua.nure;

public class ObjectTypeChecker {
    // Метод перевіряє тип переданого об'єкта
    public static void checkObjectType(Object obj) {
        if (obj instanceof Integer) {
            Integer intValue = (Integer) obj;
            System.out.println("Передали Integer: " + intValue);
        } else if (obj instanceof Double) {
            Double doubleValue = (Double) obj;
            System.out.println("Передали Double: " + doubleValue);
        } else {
            System.out.println("Передали інший тип: " + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        // Викликаємо метод з різними типами об'єктів
        checkObjectType(42);       // Передаємо Integer
        checkObjectType(3.14);     // Передаємо Double
        checkObjectType("Hello");  // Передаємо String
        checkObjectType(100L);     // Передаємо Long
        checkObjectType(true);     // Передаємо Boolean
    }
}
