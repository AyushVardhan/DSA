package com.designpatterns.commandpattern.commands;

import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public abstract class Command {

    protected ElectronicDevice eDevice;
    public abstract void execute();

}
