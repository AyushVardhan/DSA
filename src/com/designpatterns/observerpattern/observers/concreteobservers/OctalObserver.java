package com.designpatterns.observerpattern.observers.concreteobservers;

import com.designpatterns.observerpattern.subjects.SubjectAbstract;

public class OctalObserver extends Observer {

    public OctalObserver(SubjectAbstract subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Value in OctalObserver :: " + subject.getState());
    }
}
