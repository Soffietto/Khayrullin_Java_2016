package com.jetbrains.calculator.service;

import com.jetbrains.calculator.service.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    private Calculator calculator;
    private double N_1;
    private double N_2;
    private char operation;
    private final Pattern CALCULATOR_PATTERN = Pattern.compile("/calculator/(?<variableA>\\d+(\\d)*)(?<operation>(\\+|-|/|\\*))(?<variableB>\\d+(\\d)*)");
    private Matcher m = null;
    private Double result;

    private void parseCalculation(String message) {
        m = CALCULATOR_PATTERN.matcher(message);
        if (m.matches()) {
            this.N_1 = Double.parseDouble(m.group("variableA"));
            this.N_2 = Double.parseDouble(m.group("variableB"));
            this.operation = m.group("operation").charAt(0);
        }
    }

    public double calculate(String message) {
        calculator = new Calculator();
        parseCalculation(message);
        switch (operation) {
            case '+':
                result = calculator.sum(N_1, N_2);
                break;
            case '-':
                result = calculator.sub(N_1, N_2);
                break;
            case '/':
                if (N_2 == 0)
                    throw new ArithmeticException("You can't divide by zero");
                else
                    result = calculator.div(N_1, N_2);
                break;
            case '*':
                result = calculator.mult(N_1, N_2);
                break;
        }
        return result;
    }
}
