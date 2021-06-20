package com.designpatterns.command.device;

import com.designpatterns.command.commands.Command;

public class DeviceButton {
    Command command;

    public DeviceButton (Command cmd) {
        command = cmd;
    }

    public void press() {
        command.execute();
    }
}
