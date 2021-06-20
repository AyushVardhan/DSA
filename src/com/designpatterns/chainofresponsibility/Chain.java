package com.designpatterns.chainofresponsibility;

public interface Chain {
    void add(Chain nextChain);
    void calculate(Number numOp);
}
