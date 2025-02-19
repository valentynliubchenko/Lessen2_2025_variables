package ua.nure;

public class AppExampleObjectOverride {
    public static void main(String[] args) {
        // Створення двох об'єктів ExampleObjectOverride
        ExampleObjectOverride obj1 = new ExampleObjectOverride(1);
        ExampleObjectOverride obj2 = new ExampleObjectOverride(2);
        ExampleObjectOverride obj3 = new ExampleObjectOverride(1);

        // Виведення об'єктів через перевизначений метод toString()
        System.out.println("Object 1: " + obj1);
        System.out.println("Object 2: " + obj2);
        System.out.println("Object 3: " + obj3);

        // Перевірка рівності об'єктів через перевизначений метод equals()
        System.out.println("\nAre obj1 and obj2 equal? " + obj1.equals(obj2)); // false
        System.out.println("Are obj1 and obj3 equal? " + obj1.equals(obj3)); // true

        // Виведення хеш-кодів об'єктів через перевизначений метод hashCode()
        System.out.println("\nHashCode of obj1: " + Integer.toHexString(obj1.hashCode())); // хеш-код в шістнадцятковому форматі
        System.out.println("HashCode of obj2: " + Integer.toHexString(obj2.hashCode())); // хеш-код в шістнадцятковому форматі
        System.out.println("HashCode of obj3: " + Integer.toHexString(obj3.hashCode())); // хеш-код в шістнадцятковому форматі
    }
}
