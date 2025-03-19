package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppDataProcesssor
{
    public static void main( String[] args )
    {
        Integer[] integers = {5, 2, 8, 1, 9};
        DataProcessor<Integer> intProcessor = new DataProcessor<>(integers);

        System.out.println("Максимум: " + intProcessor.findMax()); // 9
        System.out.println("Середнє: " + intProcessor.average()); // 5.0
// Наступний код викличе помилку компіляції:
     //   DataProcessor<String> strProcessor = new DataProcessor<>(new String[]{"a", "b"}); // Помилка! String не є підкласом Number

    }
}
