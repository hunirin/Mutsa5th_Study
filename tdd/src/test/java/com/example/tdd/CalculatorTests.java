package com.example.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTests {
    @Test
    public void additionTest() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(2, 3));
        assertNotEquals(5, calculator.add(2, 2));
    }

    public class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
    }
}