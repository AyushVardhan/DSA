package com.designpatterns.commandpattern.commands.tvcommands;

import com.designpatterns.commandpattern.commands.Command;
import com.designpatterns.commandpattern.device.machine.ElectronicDevice;

public class TurnTvVolumeUp extends Command {

    public TurnTvVolumeUp(ElectronicDevice device) {
        eDevice = device;
    }
    @Override
    public void execute() {
        eDevice.volUp();
    }
}
