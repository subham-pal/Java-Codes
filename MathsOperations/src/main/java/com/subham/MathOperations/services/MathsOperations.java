package com.subham.MathOperations.services;

import com.subham.MathsOperations.models.MathOperators;

public class MathsOperations {
    public int add(MathOperators mathOperators){
        return mathOperators.getX() + mathOperators.getY();
    }
    public int multiply(MathOperators mathOperators){
        return mathOperators.getX() * mathOperators.getY();
    }
    public int subtract(MathOperators mathOperators){
        return mathOperators.getX() - mathOperators.getY();
    }
    public int divide(MathOperators mathOperators) throws ArithmeticException{
        return mathOperators.getX() / mathOperators.getY();
    }
}
