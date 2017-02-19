package com.jetbrainslab.calculator.service;

import com.jetbrainslab.calculator.enums.Operations;

public class Service {
    private Calculator calculator;

    public double calculate(double firstNumber, double secondNumber, Operations operation) {
        double result = 0;
        calculator = new Calculator();
        switch (operation) {
            case SUM:
                result = calculator.sum(firstNumber, secondNumber);
                break;
            case SUB:
                result = calculator.sub(firstNumber, secondNumber);
                break;
            case MULT:
                result = calculator.mult(firstNumber, secondNumber);
                break;
            case DIV:
                result = calculator.div(firstNumber, secondNumber);
                break;
        }
        return result;
    }
}
