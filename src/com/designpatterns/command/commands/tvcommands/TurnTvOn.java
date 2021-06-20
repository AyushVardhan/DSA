package com.designpatterns.command.commands.tvcommands;

import com.designpatterns.command.commands.Command;
import com.designpatterns.command.device.machine.ElectronicDevice;

public class TurnTvOn extends Command {

    public TurnTvOn(ElectronicDevice device) {
        eDevice = device;
    }
    @Override
    public void execute() {
        eDevice.turnOn();
    }
}
