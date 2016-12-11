package com.jetbrains.calculator.service;

import com.sun.org.apache.xml.internal.utils.WrongParserException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceTest {
    private static Calculator calculator;
    private static Service service;
    private static final double N_1 = 10;
    private static final double N_2 = 5;
    private static final double DELTA = 10e-2;
    private static final String SUM_EXPRESSION = "/calculator/10+5";
    private static final String SUB_EXPRESSION = "/calculator/10-5";
    private static final String MULT_EXPRESSION = "/calculator/10*5";
    private static final String DIV_EXPRESSION = "/calculator/10/5";
    private static final String WRONG_PARSER_EXPRESSION = "/calculator/a+1";
    private static final String EXCEPTION_EXPRESSION = "/calculator/7/0";

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
        service = new Service();
    }

    @Test
    public void calculateShouldReturnCorrectSum() {
        Assert.assertEquals(service.calculate(SUM_EXPRESSION), calculator.sum(N_1, N_2), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectSub() {
        Assert.assertEquals(service.calculate(SUB_EXPRESSION), calculator.sub(N_1, N_2), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectMult() {
        Assert.assertEquals(service.calculate(MULT_EXPRESSION), calculator.mult(N_1, N_2), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectDiv() {
        Assert.assertEquals(service.calculate(DIV_EXPRESSION), calculator.div(N_1, N_2), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void calculateShouldReturnAriphmeticException() {
        service.calculate(EXCEPTION_EXPRESSION);
    }

    @Test(expected = WrongParserException.class)
    public void calculateShouldReturnWrongParserException() {
        service.calculate(WRONG_PARSER_EXPRESSION);
    }
}
