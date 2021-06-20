package com.designpatterns.chainofresponsibility;

import com.designpatterns.chainofresponsibility.chain.AddChain;
import com.designpatterns.chainofresponsibility.chain.SubChain;

public class Client {
    public static void main(String[] args) {
        Chain ch1 = new AddChain();
        Chain ch2 = new SubChain();

        ch1.add(ch2);

        ch1.calculate(new Number("sub",5,3));
        ch1.calculate(new Number("add",5,3));
    }
}
