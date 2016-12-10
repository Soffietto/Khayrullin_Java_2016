package com.jetbrains.calculator.service;

import com.sun.org.apache.xml.internal.utils.WrongParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    private Calculator calculator;
    private double Number1;
    private double Number2;
    private char operation;
    private final Pattern CALCULATOR_PATTERN = Pattern.compile("/calculator/(?<variableA>\\d+(\\d)*)(?<operation>(\\+|-|/|\\*))(?<variableB>\\d+(\\d)*)");
    private Matcher m = null;
    private Double result;

    private void parseCalculation(String message) {
        m = CALCULATOR_PATTERN.matcher(message);
        if (m.matches()) {
            this.Number1 = Double.parseDouble(m.group("variableA"));
            this.Number2 = Double.parseDouble(m.group("variableB"));
            this.operation = m.group("operation").charAt(0);
        }else {
            throw new WrongParserException("Wrong expression");
        }
    }

    public double calculate(String message) {
        calculator = new Calculator();
        parseCalculation(message);
        switch (operation) {
            case '+':
                result = calculator.sum(Number1, Number2);
                break;
            case '-':
                result = calculator.sub(Number1, Number2);
                break;
            case '/':
                result = calculator.div(Number1, Number2);
                break;
            case '*':
                result = calculator.mult(Number1, Number2);
                break;
        }
        return result;
    }
}
