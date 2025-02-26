package ua.nure;

/**
 * Hello world!
 *
 */
public class AppString
{
    public static void main( String[] args )
    {
        String input = " Java programming ";

        System.out.println("Довжина: " + input.length());
        System.out.println("Без пробілів: '" + input.trim() + "'");
        System.out.println("Верхній регістр: " + input.toUpperCase());
        System.out.println("Чи містить 'Java': " + input.contains("Java"));
        processUserInput("Hello, World!");
        checkEquality("java", "Java");
        parseAndFormatNumber("100");
        String str = String.format("Hello, %s! %d", "World", 123); // printf
        System.out.println(str);
        System.out.printf("%d, %.3f", 321, 3.2564);
    }


    public static void processUserInput(String text) {
        System.out.println("\n--- Обробка рядка ---");
        System.out.println("Перший символ: " + text.charAt(0));
        System.out.println("Замінюємо 'o' на '0': " + text.replace("o", "0"));

        String[] words = text.split(" ");
        System.out.println("Розбиття на слова:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Перевірка рівності рядків
    public static void checkEquality(String str1, String str2) {
        System.out.println("\n--- Перевірка рівності ---");
        System.out.println("Чутливе до регістру: " + str1.equals(str2));
        System.out.println("Без урахування регістру: " + str1.equalsIgnoreCase(str2));
    }

    // Перетворення рядків у числа і навпаки
    public static void parseAndFormatNumber(String numStr) {
        System.out.println("\n--- Робота з числами ---");
        int num = Integer.parseInt(numStr);
        System.out.println("Число + 50: " + (num + 50));

        String formatted = String.valueOf(num * 2);
        System.out.println("Перетворене у рядок: " + formatted);
    }
}
