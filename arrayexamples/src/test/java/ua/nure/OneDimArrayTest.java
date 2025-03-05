package ua.nure;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OneDimArrayTest {


    private OneDimArray array;
    private static final int ARRAY_SIZE = 10;

    @BeforeEach
    void setUp() {
        log.info("Run BeforeEach");
        array = new OneDimArray(ARRAY_SIZE);
    }

    @Test
    @DisplayName("Конструктор повинен створювати масив правильного розміру")
    void constructorShouldCreateArrayWithCorrectSize() {
        assertThat(array.getArray()).hasSize(ARRAY_SIZE);
    }


    @Test
    @DisplayName("Конструктор повинен викидати виняток при некоректному розмірі")
    void constructorShouldThrowExceptionForInvalidSize() {
        assertThatThrownBy(() -> new OneDimArray(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error size must be greater than 0");
    }

    @Test
    @DisplayName("Метод fillRandom повинен заповнювати масив значеннями у заданому діапазоні")
    void fillRandomShouldPopulateArrayWithValuesInRange() {
        int min = 1;
        int max = 100;
        array.fillRandom(min, max);

        int[] values = array.getArray();
        assertThat(values).isNotEmpty();

        for (int value : values) {
            assertThat(value).isGreaterThanOrEqualTo(min);
            assertThat(value).isLessThanOrEqualTo(max);
        }
    }

    @Test
    @DisplayName("Метод sum повинен правильно обчислювати суму елементів")
    void sumShouldCalculateTotalCorrectly() {
        // Заповнимо масив конкретними значеннями для тестування
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.arraycopy(testArray, 0, array.getArray(), 0, ARRAY_SIZE);

        int expectedSum = 55; // 1 + 2 + ... + 10 = 55
        assertThat(array.sum()).isEqualTo(expectedSum);
    }

    @Test
    @DisplayName("Метод sort повинен сортувати масив за зростанням")
    void sortShouldArrangeElementsInAscendingOrder() {
        // Заповнимо масив невпорядкованими значеннями
        int[] unsortedArray = {5, 2, 9, 1, 7, 3, 8, 6, 4, 10};
        System.arraycopy(unsortedArray, 0, array.getArray(), 0, ARRAY_SIZE);

        array.sort();

        assertThat(array.getArray())
                .isSorted()
                .containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }


}