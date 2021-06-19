package com.designpatterns.observerpattern.subjects;

import com.designpatterns.observerpattern.observers.concreteobservers.Observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImplOne extends SubjectAbstract {

    List<Observer> observerList;

    public SubjectImplOne(int st) {
        observerList = new ArrayList<>();
        state = st;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    @Override
    public void register(Observer ob) {
        observerList.add(ob);
    }

    @Override
    public void unregister(Observer ob) {
        observerList.remove(ob);
    }

    @Override
    public void notifyAllObserver() {
        if (observerList.isEmpty())
            System.out.println("Nothing available in Subject-One list");

        for (Observer ob : observerList)
            ob.update();
    }
}
