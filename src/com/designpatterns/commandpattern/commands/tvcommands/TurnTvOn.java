package com.designpatterns.commandpattern.commands.tvcommands;

import com.designpatterns.commandpattern.commands.Command;
import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public class TurnTvOn extends Command {

    public TurnTvOn(ElectronicDevice device) {
        eDevice = device;
    }
    @Override
    public void execute() {
        eDevice.turnOn();
    }
}
