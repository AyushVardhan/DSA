package com.designpatterns.command.commands.tvcommands;

import com.designpatterns.command.commands.Command;
import com.designpatterns.command.device.machine.ElectronicDevice;

public class TurnTvOff extends Command {

    public TurnTvOff(ElectronicDevice device) {
        eDevice = device;
    }

    @Override
    public void execute() {
        eDevice.turnOff();
    }
}
