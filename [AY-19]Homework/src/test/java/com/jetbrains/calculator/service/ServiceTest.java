package com.jetbrains.calculator.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceTest {
    private static Calculator calculator;
    private static Service service;
    private static final double N_1 = 10;
    private static final double N_2 = 5;
    private static final double DELTA = 10e-2;
    private static final String PROPPER_EXPRESSION_SUM = "/calculator/10+5";
    private static final String PROPPER_EXPRESSION_SUB = "/calculator/10-5";
    private static final String PROPPER_EXPRESSION_MULT = "/calculator/10*5";
    private static final String PROPPER_EXPRESSION_DIV = "/calculator/10/5";
    private static final String ERROR_EXPRESSION = "/calculator/a+1";
    private static final String EXCEPTION_EXPRESSION = "/calculator/7/0";

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
        service = new Service();
    }

    @Test
    public void shouldReturnCorrectSum() {
        Assert.assertEquals(service.calculate(PROPPER_EXPRESSION_SUM), calculator.sum(N_1, N_2), DELTA);
    }

    @Test
    public void shouldReturnCorrectSub() {
        Assert.assertEquals(service.calculate(PROPPER_EXPRESSION_SUB), calculator.sub(N_1, N_2), DELTA);
    }

    @Test
    public void shouldReturnCorrectMult() {
        Assert.assertEquals(service.calculate(PROPPER_EXPRESSION_MULT), calculator.mult(N_1, N_2), DELTA);
    }

    @Test
    public void shouldReturnCorrectDiv() {
        Assert.assertEquals(service.calculate(PROPPER_EXPRESSION_DIV), calculator.div(N_1, N_2), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldReturnException() {
        service.calculate(EXCEPTION_EXPRESSION);
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnError() {
        service.calculate(ERROR_EXPRESSION);
    }
}
