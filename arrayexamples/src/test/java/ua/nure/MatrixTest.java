package ua.nure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void sum() {
        Matrix matrix = new Matrix(10);
        assertEquals(10, matrix.sum());
    }
}