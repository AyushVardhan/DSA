package com.designpatterns.chainofresponsibility;

public class Number {
    private int n1;
    private int n2;
    private String calcRequired;

    public Number(String calc, int num1, int num2) {
        n1 = num1;
        n2 = num2;
        calcRequired = calc;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public String getCalcRequired() {
        return calcRequired;
    }

    public void setCalcRequired(String calcRequired) {
        this.calcRequired = calcRequired;
    }
}
