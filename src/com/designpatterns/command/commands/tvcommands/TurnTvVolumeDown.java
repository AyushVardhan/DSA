package com.designpatterns.command.commands.tvcommands;

import com.designpatterns.command.commands.Command;
import com.designpatterns.command.device.machine.ElectronicDevice;

public class TurnTvVolumeDown extends Command {

    public TurnTvVolumeDown(ElectronicDevice device) {
        eDevice = device;
    }
    @Override
    public void execute() {
        eDevice.volDown();
    }
}
