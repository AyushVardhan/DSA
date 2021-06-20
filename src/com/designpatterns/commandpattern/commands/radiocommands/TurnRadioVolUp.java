package com.designpatterns.commandpattern.commands.radiocommands;

import com.designpatterns.commandpattern.commands.Command;
import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public class TurnRadioVolUp extends Command {

    public TurnRadioVolUp(ElectronicDevice device) {
        eDevice = device;
    }

    @Override
    public void execute() {
        eDevice.volUp();
    }
}
