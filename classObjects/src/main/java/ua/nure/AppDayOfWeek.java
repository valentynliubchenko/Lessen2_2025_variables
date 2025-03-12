package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppDayOfWeek
{
    public static void main( String[] args )
    {
        DayOfWeek today = DayOfWeek.MONDAY;
        System.out.println("Сьогодні: " + today);

        // Перебір усіх констант enum
        System.out.println("Всі дні тижня:");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day.ordinal() + ": " + day.name());
        }

        // Перетворення рядка в enum
        DayOfWeek friday = DayOfWeek.valueOf("FRIDAY");
        System.out.println("Перетворено з рядка: " + friday);

        // Порівняння констант
        if (today.compareTo(friday) < 0) {
            System.out.println("Понеділок настає раніше ніж п'ятниця");
        }

    }
}
