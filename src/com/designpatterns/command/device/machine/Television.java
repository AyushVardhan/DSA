package com.designpatterns.command.device.machine;

public class Television implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off");
    }

    @Override
    public void volUp() {
        System.out.println("TV volume is increased by one");
    }

    @Override
    public void volDown() {
        System.out.println("TV volume is decreased by one");
    }
}
