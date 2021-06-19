package com.designpatterns.observerpattern.observers.concreteobservers;

import com.designpatterns.observerpattern.subjects.SubjectAbstract;

public class BinaryObserver extends Observer {

    public BinaryObserver (SubjectAbstract subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Value in BinaryObserver :: " + subject.getState());
    }
}
