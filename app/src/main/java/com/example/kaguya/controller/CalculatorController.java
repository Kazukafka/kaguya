package com.example.kaguya.controller;

import com.example.kaguya.defaultvalues.Operation;

public class CalculatorController {
    public double getNumberFirst() {
        return numberFirst;
    }

    public void setNumberFirst(double numberFirst) {
        this.numberFirst = numberFirst;
    }

    public double getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(double numberSecond) {
        this.numberSecond = numberSecond;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        switch (operation) {
            case ADDITION:
                operationSign = "+";
                break;
            case SUBTRACTION:
                operationSign = "-";
                break;
            case DIVISION:
                operationSign = "/";
                break;
            case MULTIPLICATION:
                operationSign = "*";
                break;
            case POWER:
                operationSign = "^";
                break;
        }
    }

    private double numberFirst, numberSecond, result;
    private Operation operation;
    private String operationSign;

    public void calculate() throws Exception {
        if(operation == Operation.ADDITION) {
            result = numberFirst + numberSecond;
        }
        else if(operation == Operation.SUBTRACTION) {
            result = numberFirst - numberSecond;
        }
        else if(operation == Operation.MULTIPLICATION) {
            result = numberFirst * numberSecond;
        }
        else if(operation == Operation.DIVISION) {
            if(numberSecond == 0) {
                throw new Exception("Cannot divide by zero");
            }
            result = numberFirst / numberSecond;
        }
        else if(operation == Operation.POWER) {
            result = Math.pow(numberFirst,numberSecond);
        }
    }

    public String printResult() {
        return String.valueOf(result);
    }

    public String printEquation() {
        String resultString = new StringBuilder().append(numberFirst).append(operationSign).append(numberSecond).append(" = ").append(result).toString();
        return resultString;
    }
}
