package ua.nure;

public class AppIntegerExample {
    public static void main(String[] args) {
        // Автопакування: примітивне значення int автоматично перетворюється на Integer
        Integer intObject = 100; // Це еквівалентно Integer intObject = Integer.valueOf(100);

        // Використання методів класу Integer
        int primitiveInt = intObject.intValue(); // Розпакування значення в примітив тип int
        System.out.println("Значення int: " + primitiveInt);

        // Перевірка на порівняння значень
        Integer anotherIntObject = 100;
        if (intObject.equals(anotherIntObject)) {
            System.out.println("Значення однакові.");
        }

        // Перетворення рядка в число
        String str = "250";
        Integer parsedValue = Integer.parseInt(str);
        System.out.println("Парсинг рядка у число: " + parsedValue);

        // Перетворення числа в строку
        String strFromInt = intObject.toString();
        strFromInt +=intObject;
        System.out.println("Число як рядок: " + strFromInt);
    }
}
