package com.designpatterns.chainofresponsibility.chain;

import com.designpatterns.chainofresponsibility.Chain;
import com.designpatterns.chainofresponsibility.Number;

public class AddChain implements Chain {

    Chain nextInChain;

    @Override
    public void add(Chain nextChain) {
        nextInChain = nextChain;
    }

    @Override
    public void calculate(Number numOp) {
        if (numOp.getCalcRequired().equalsIgnoreCase("Add")) {
            int sum = numOp.getN1() + numOp.getN2();
            System.out.println("Result : " + sum);
        } else {
            nextInChain.calculate(numOp);
        }
    }
}
