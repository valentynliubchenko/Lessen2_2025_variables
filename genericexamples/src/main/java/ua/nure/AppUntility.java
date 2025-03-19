package ua.nure;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class AppUntility
{
    public static void main( String[] args )
    {
        Utility utility = new Utility();
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));
        utility.swap(numbers, 0, 4); // 5, 2, 3, 4, 1
        System.out.println(Arrays.toString(numbers));
    }
}
