package com.designpatterns.decoratorpattern;

public class ToppingsDecorator implements Pizza {

    protected Pizza tempPizza;
    public ToppingsDecorator(Pizza pizza) {
        tempPizza = pizza;
    }

    @Override
    public String getDesc() {
        return tempPizza.getDesc();
    }

    @Override
    public double getCost() {
        return tempPizza.getCost();
    }
}
