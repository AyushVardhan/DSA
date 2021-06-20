package com.designpatterns.commandpattern.commands.tvcommands;

import com.designpatterns.commandpattern.commands.Command;
import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public class TurnTvVolumeDown extends Command {

    public TurnTvVolumeDown(ElectronicDevice device) {
        eDevice = device;
    }
    @Override
    public void execute() {
        eDevice.volDown();
    }
}
