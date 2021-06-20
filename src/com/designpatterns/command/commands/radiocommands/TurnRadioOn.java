package com.designpatterns.command.commands.radiocommands;

import com.designpatterns.command.commands.Command;
import com.designpatterns.command.device.machine.ElectronicDevice;

public class TurnRadioOn extends Command {

    public TurnRadioOn(ElectronicDevice device) {
        eDevice = device;
    }

    @Override
    public void execute() {
        eDevice.turnOn();
    }
}
