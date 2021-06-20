package com.designpatterns.commandpattern.device;

import com.designpatterns.commandpattern.commands.Command;

public class DeviceButton {
    Command command;

    public DeviceButton (Command cmd) {
        command = cmd;
    }

    public void press() {
        command.execute();
    }
}
