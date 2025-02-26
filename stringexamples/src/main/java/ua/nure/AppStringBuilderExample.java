package ua.nure;

public class AppStringBuilderExample {
    public static void main(String[] args) {
        // Створюємо StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // Виводимо початковий хешкод
        System.out.println("Initial hashcode: " + Integer.toHexString(sb.hashCode()));

        // Додаємо рядок
        sb.append(" World!");
        System.out.println("After append: " + sb.toString());
        System.out.println("Hashcode after append: " + Integer.toHexString(sb.hashCode()));

        // Вставляємо рядок
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb.toString());
        System.out.println("Hashcode after insert: " + Integer.toHexString(sb.hashCode()));

        // Видаляємо частину рядка
        sb.delete(5, 11);
        System.out.println("After delete: " + sb.toString());
        System.out.println("Hashcode after delete: " + Integer.toHexString(sb.hashCode()));

        // Видаляємо символ за індексом
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb.toString());
        System.out.println("Hashcode after deleteCharAt: " + Integer.toHexString(sb.hashCode()));

        // Заміна частини рядка
        sb.replace(6, 15, "Universe");
        System.out.println("After replace: " + sb.toString());
        System.out.println("Hashcode after replace: " + Integer.toHexString(sb.hashCode()));

        // Перевертаємо рядок
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());
        System.out.println("Hashcode after reverse: " + Integer.toHexString(sb.hashCode()));

        // Встановлюємо нову довжину
        sb.setLength(5);
        System.out.println("After setLength: " + sb.toString());
        System.out.println("Hashcode after setLength: " + Integer.toHexString(sb.hashCode()));

        // Отримуємо символ за індексом
        char c = sb.charAt(1);
        System.out.println("Character at index 1: " + c);
        System.out.println("Hashcode after charAt: " + Integer.toHexString(sb.hashCode()));

        // Заміна символу за індексом
        sb.setCharAt(0, 'J');
        System.out.println("After setCharAt: " + sb.toString());
        System.out.println("Hashcode after setCharAt: " + Integer.toHexString(sb.hashCode()));

        // Перетворюємо в String
        String str = sb.toString();
        System.out.println("After toString: " + str);
        System.out.println("Hashcode after toString: " + Integer.toHexString(sb.hashCode()));
    }
}
