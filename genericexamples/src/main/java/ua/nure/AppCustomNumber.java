package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppCustomNumber
{
    public static void main( String[] args )    {
// Це працює, бо Integer реалізує обидва обмеження
        Integer[] integers = {5, 2, 9, 1, 7};
        DataProcessor<Integer> intProcessor = new DataProcessor<>(integers);
//        System.out.println("Максимальне число: " + intProcessor.findMax());
        System.out.println("Середнє значення: " + intProcessor.average());

        // Спробуємо з нашим власним типом
        CustomNumber[] customNumbers = {
                new CustomNumber(5.5),
                new CustomNumber(2.2),
                new CustomNumber(9.9)
        };

//         Наступний рядок викличе ПОМИЛКУ КОМПІЛЯЦІЇ,
//         тому що CustomNumber не реалізує Comparable<CustomNumber>
        DataProcessor<CustomNumber> customProcessor = new DataProcessor<>(customNumbers);
        System.out.println("\nРобота з CustomNumber:");
        System.out.println("Максимальне значення: " + customProcessor.findMax());
        System.out.println("Середнє значення: " + customProcessor.average());
    }
}
