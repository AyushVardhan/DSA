package com.designpatterns.decoratorpattern.toppings;

import com.designpatterns.decoratorpattern.Pizza;
import com.designpatterns.decoratorpattern.ToppingsDecorator;

public class Mozarella extends ToppingsDecorator {

    public Mozarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDesc() {
        return tempPizza.getDesc() + " ,Mozarella";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 150.0;
    }
}
