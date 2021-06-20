package com.designpatterns.command.commands;

import com.designpatterns.command.device.machine.ElectronicDevice;

public abstract class Command {

    protected ElectronicDevice eDevice;
    public abstract void execute();

}
