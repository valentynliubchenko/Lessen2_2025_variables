package ua.nure;

public class AppStringCamelCase {
    public static void main(String[] args) {
        String input = "Hello,    woRTld  ,  java     programming!"; //"HelloWorldJavaProgramming";
        System.out.println("Origina: "+input);
        System.out.println("Hex: "+Integer.toHexString(input.hashCode()));
        String result ="";
        String[] words = input.split("[,\\s!]+");
        for (String word : words) {
            result += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
            System.out.println("Current result: "+result);
            System.out.println("Curent Hex: "+Integer.toHexString(result.hashCode()));
        }

        System.out.println("result: "+result);
        System.out.println("Hex: "+Integer.toHexString(result.hashCode()));

    }
}
