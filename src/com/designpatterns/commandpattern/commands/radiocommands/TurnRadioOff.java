package com.designpatterns.commandpattern.commands.radiocommands;

import com.designpatterns.commandpattern.commands.Command;
import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public class TurnRadioOff extends Command {

    public TurnRadioOff(ElectronicDevice device) {
        eDevice = device;
    }

    @Override
    public void execute() {
        eDevice.turnOff();
    }
}
