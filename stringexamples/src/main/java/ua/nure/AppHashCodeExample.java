package ua.nure;

import java.util.Objects;

public class AppHashCodeExample {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        System.out.println("Хешкод str1: " + Integer.toHexString(str1.hashCode()));
        System.out.println("Хешкод str2: " + Integer.toHexString(str2.hashCode()));
        System.out.println("Хешкод str3: " + Integer.toHexString(str3.hashCode()));

        // Створимо нові об'єкти з різними даними
        String str4 = "world";
        System.out.println("Хешкод str4: " + Integer.toHexString(str4.hashCode()));
        str3="new value";
        System.out.println("Хешкод str3: " + Integer.toHexString(str3.hashCode()));
        System.out.println("Хешкод str3: " + Integer.toHexString(Objects.hashCode(str3)));
    }
}
