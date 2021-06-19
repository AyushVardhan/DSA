package com.designpatterns.observerpattern.observers.concreteobservers;

import com.designpatterns.observerpattern.subjects.SubjectAbstract;

public abstract class Observer {

    SubjectAbstract subject;
    public abstract void update();

}
