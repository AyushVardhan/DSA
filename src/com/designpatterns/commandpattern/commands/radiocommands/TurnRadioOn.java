package com.designpatterns.commandpattern.commands.radiocommands;

import com.designpatterns.commandpattern.commands.Command;
import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public class TurnRadioOn extends Command {

    public TurnRadioOn(ElectronicDevice device) {
        eDevice = device;
    }

    @Override
    public void execute() {
        eDevice.turnOn();
    }
}
