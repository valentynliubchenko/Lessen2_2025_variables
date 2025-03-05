package ua.nure;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

@Slf4j
@Getter
public class OneDimensionalArray {
    private int[] array;

    public OneDimensionalArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір масиву повинен бути більше 0");
        }
        this.array = new int[size];
        log.info("Створено одновимірний масив розміром {}", size);
    }

    public void fillRandom(int min, int max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        log.info("Масив заповнено випадковими значеннями в діапазоні [{}, {}]", min, max);
    }

    public int sum() {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        log.debug("Сума елементів масиву: {}", total);
        return total;
    }

    public void sort() {
        Arrays.sort(array);
        log.info("Масив відсортовано за зростанням");
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
