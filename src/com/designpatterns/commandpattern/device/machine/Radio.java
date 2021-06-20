package com.designpatterns.commandpattern.device.machine;

public class Radio implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Radio is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned off");
    }

    @Override
    public void volUp() {
        System.out.println("Radio volume is increased by one");
    }

    @Override
    public void volDown() {
        System.out.println("Radio volume is decreased by one");
    }
}
