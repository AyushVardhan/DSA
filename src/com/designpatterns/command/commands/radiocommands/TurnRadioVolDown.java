package com.designpatterns.command.commands.radiocommands;

import com.designpatterns.command.commands.Command;
import com.designpatterns.command.device.machine.ElectronicDevice;

public class TurnRadioVolDown extends Command {

    public TurnRadioVolDown(ElectronicDevice device) {
        eDevice = device;
    }

    @Override
    public void execute() {
        eDevice.volDown();
    }
}
