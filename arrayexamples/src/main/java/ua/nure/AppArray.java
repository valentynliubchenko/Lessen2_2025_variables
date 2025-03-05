package ua.nure;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class AppArray
{
    public static void main( String[] args )
    {
        log.info("Start");
        log.error("Some error");
        log.warn("Some warning");
        log.debug("Some debug");

        int[] mas = {3,4,5,6,7,8,9,10};
        System.out.println(mas.length);

        int [][] matr = new int[3][5];
        int [][] matr2  = {
                {1,2,3},
                {2},
                {3,4}
        };

        for (int i = 0; i < matr2.length; i++) {
            for (int j = 0; j < matr2[i].length; j++) {
                System.out.print(matr2[i][j]+ " ");
            }
            System.out.println();
        }
        matr2[1] = mas;
        for (int i = 0; i < matr2.length; i++) {
            for (int j = 0; j < matr2[i].length; j++) {
                System.out.print(matr2[i][j]+ " ");
            }
            System.out.println();
        }

        exampleArray();

    }

    public static void exampleArray()
    {
// Приклад масиву
        int[] numbers = {5, 3, 8, 1, 2};
        String[] names = {"Alice", "Bob", "Charlie", "David"};

        // 1. Сортування масиву
        Arrays.sort(numbers);  // Сортує масив чисел
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));

        // 2. Заповнення масиву
        Arrays.fill(numbers, 0);  // Заповнює масив значенням 0
        System.out.println("Filled numbers: " + Arrays.toString(numbers));

        // 3. Копіювання частини масиву
        int[] copiedNumbers = Arrays.copyOfRange(numbers, 1, 3);  // Копіює частину масиву (від індексу 1 до 3)
        System.out.println("Copied numbers (from index 1 to 3): " + Arrays.toString(copiedNumbers));

        // 4. Порівняння масивів
        int[] anotherNumbers = {0, 0, 0, 0, 0};
        System.out.println("Arrays are equal: " + Arrays.equals(numbers, anotherNumbers));

        // 5. Пошук в масиві (якщо масив відсортований)
        int index = Arrays.binarySearch(numbers, 2);  // Бінарний пошук значення 2
        System.out.println("Index of 2: " + index);

        // 6. Сортування масиву за допомогою компаратора
        Arrays.sort(names, Comparator.reverseOrder());  // Сортує масив строк у зворотньому порядку
        System.out.println("Sorted names in reverse order: " + Arrays.toString(names));

        // 7. Перетворення масиву в список
        System.out.println("Names as list: " + Arrays.asList(names));

        // 8. Глибоке порівняння масивів (для багатовимірних масивів)
        int[][] multiDimArray = {{1, 2}, {3, 4}};
        int[][] anotherMultiDimArray = {{1, 2}, {3, 4}};
        System.out.println("Multidimensional arrays are equal: " + Arrays.deepEquals(multiDimArray, anotherMultiDimArray));

        // 9. Перетворення масиву в стрічку
        System.out.println("Names as string: " + Arrays.toString(names));


        OneDimArray oneDimArray = new OneDimArray(10);
        oneDimArray.fillRandom(4,5);
        System.out.println(oneDimArray);
        log.info(oneDimArray.toString());

    }

}
