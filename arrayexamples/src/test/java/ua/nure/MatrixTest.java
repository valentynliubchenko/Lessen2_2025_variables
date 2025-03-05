package ua.nure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void sum() {
        Matrix matrix = new Matrix(10);
        //TODO Необхідно виправити
        assertEquals(0, matrix.sum());
    }
}