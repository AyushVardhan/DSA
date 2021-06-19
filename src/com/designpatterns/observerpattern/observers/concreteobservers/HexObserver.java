package com.designpatterns.observerpattern.observers.concreteobservers;

import com.designpatterns.observerpattern.subjects.SubjectAbstract;

public class HexObserver extends Observer {

    public HexObserver(SubjectAbstract subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Value in HexObserver :: " + subject.getState());
    }
}
