package com.designpatterns.observerpattern.subjects;

import com.designpatterns.observerpattern.observers.concreteobservers.Observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImplTwo extends SubjectAbstract {

    List<Observer> observerList;

    public SubjectImplTwo(int st) {
        observerList = new ArrayList<>();
        state = st;
    }

    @Override
    public void setState(int st) {
        this.state = st;
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
            System.out.println("Nothing available in Subject-Two list");


        for (Observer ob : observerList)
            ob.update();
    }

    @Override
    public int getState() {
        return state;
    }
}
