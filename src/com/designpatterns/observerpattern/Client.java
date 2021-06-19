package com.designpatterns.observerpattern;

import com.designpatterns.observerpattern.observers.concreteobservers.BinaryObserver;
import com.designpatterns.observerpattern.observers.concreteobservers.HexObserver;
import com.designpatterns.observerpattern.observers.concreteobservers.OctalObserver;
import com.designpatterns.observerpattern.subjects.SubjectImplOne;
import com.designpatterns.observerpattern.subjects.SubjectImplTwo;

public class Client {
    public static void main(String[] args) {
        SubjectImplOne subject1 = new SubjectImplOne(0);
        BinaryObserver binaryObserver1 = new BinaryObserver(subject1);
        OctalObserver octalObserver1 = new OctalObserver(subject1);
        HexObserver hexObserver1 = new HexObserver(subject1);

        subject1.notifyAllObserver();
        System.out.println();

        subject1.setState(2);
        System.out.println();

        subject1.unregister(binaryObserver1);
        subject1.unregister(hexObserver1);
        subject1.unregister(octalObserver1);

        subject1.setState(3);
        System.out.println();

        SubjectImplTwo subject2 = new SubjectImplTwo(-1);

        subject2.setState(3);
        System.out.println();
        subject2.setState(-1);
        System.out.println();

        BinaryObserver binaryObserver2 = new BinaryObserver(subject2);
        subject2.notifyAllObserver();
        System.out.println();
    }
}
