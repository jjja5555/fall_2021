package edu.northeastern.martin;

public class MultiplyOperation implements MathOperation{

    @Override
    public int performOperation(int num1, int num2) {
        return num1*num2;
    }
}
