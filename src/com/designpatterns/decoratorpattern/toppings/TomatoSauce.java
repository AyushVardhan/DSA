package com.designpatterns.decoratorpattern.toppings;

import com.designpatterns.decoratorpattern.Pizza;
import com.designpatterns.decoratorpattern.ToppingsDecorator;

public class TomatoSauce extends ToppingsDecorator {

    public TomatoSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDesc() {
        return tempPizza.getDesc() + " ,TomatoSauce";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 50.0;
    }
}
