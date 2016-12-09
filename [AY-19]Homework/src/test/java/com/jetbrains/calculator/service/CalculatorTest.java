package com.jetbrains.calculator.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double N_1 = 18.3d;
    private static final double N_2 = 4.8d;
    private static Calculator calculator;
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumShouldReturnCorrectSum() {
        Assert.assertEquals(N_1 + N_2, calculator.sum(N_1, N_2), DELTA);
    }

    @Test
    public void subShouldReturnCorrectSub() {
        Assert.assertEquals(N_1 - N_2, calculator.sub(N_1, N_2), DELTA);
    }

    @Test
    public void multShouldReturnCorrectMult() {
        Assert.assertEquals(N_1 * N_2, calculator.mult(N_1, N_2), DELTA);
    }

    @Test
    public void divShouldReturnCorrectDiv() {
        Assert.assertEquals(N_1 / N_2, calculator.div(N_1, N_2), DELTA);
    }
}
