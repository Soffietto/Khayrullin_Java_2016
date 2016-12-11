package com.jetbrains.calculator.service;

import com.sun.org.apache.xml.internal.utils.WrongParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    private Calculator calculator;
    private double variableA;
    private double variableB;
    private char operation;
    private static final Pattern CALCULATOR_PATTERN = Pattern.compile("/calculator/(?<variableA>\\d+(\\d)*)(?<operation>(\\+|-|/|\\*))(?<variableB>\\d+(\\d)*)");
    private Matcher m = null;
    private Double result;

    public double calculate(String message) {
        calculator = new Calculator();
        parseCalculation(message);
        switch (operation) {
            case '+':
                result = calculator.sum(variableA, variableB);
                break;
            case '-':
                result = calculator.sub(variableA, variableB);
                break;
            case '/':
                result = calculator.div(variableA, variableB);
                break;
            case '*':
                result = calculator.mult(variableA, variableB);
                break;
        }
        return result;
    }

    private void parseCalculation(String message) {
        m = CALCULATOR_PATTERN.matcher(message);
        if (m.matches()) {
            this.variableA = Double.parseDouble(m.group("variableA"));
            this.variableB = Double.parseDouble(m.group("variableB"));
            this.operation = m.group("operation").charAt(0);
        }else {
            throw new WrongParserException("Wrong expression");
        }
    }
}
