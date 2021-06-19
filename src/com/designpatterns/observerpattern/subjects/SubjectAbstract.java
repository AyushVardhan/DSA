package com.designpatterns.observerpattern.subjects;

import com.designpatterns.observerpattern.observers.concreteobservers.Observer;

public abstract class SubjectAbstract {

    int state;
    public abstract void register(Observer ob);
    public abstract void unregister(Observer ob);
    public abstract void notifyAllObserver();
    public abstract int getState();
    public abstract void setState(int st);
}
