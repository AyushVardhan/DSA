package com.designpatterns.decoratorpattern;

public class PlainPizza implements Pizza {
    @Override
    public String getDesc() {
        return "Added plainDough";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}
