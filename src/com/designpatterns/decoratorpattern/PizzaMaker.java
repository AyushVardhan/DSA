package com.designpatterns.decoratorpattern;

import com.designpatterns.decoratorpattern.toppings.Mozarella;
import com.designpatterns.decoratorpattern.toppings.TomatoSauce;

public class PizzaMaker {
    public static void main(String[] args) {
        Pizza pizza1 = new TomatoSauce(new Mozarella(new PlainPizza()));
        System.out.println("Desc : " + pizza1.getDesc() + " , Cost : " + pizza1.getCost());

        Pizza pizza2 = new TomatoSauce(new PlainPizza());
        System.out.println("Desc : " + pizza2.getDesc() + " , Cost : " + pizza2.getCost());
    }
}
