package com.designpatterns.command;

import com.designpatterns.command.commands.radiocommands.TurnRadioOff;
import com.designpatterns.command.commands.radiocommands.TurnRadioOn;
import com.designpatterns.command.commands.radiocommands.TurnRadioVolDown;
import com.designpatterns.command.commands.radiocommands.TurnRadioVolUp;
import com.designpatterns.command.commands.tvcommands.TurnTvOff;
import com.designpatterns.command.commands.tvcommands.TurnTvOn;
import com.designpatterns.command.commands.tvcommands.TurnTvVolumeDown;
import com.designpatterns.command.commands.tvcommands.TurnTvVolumeUp;
import com.designpatterns.command.device.machine.Radio;
import com.designpatterns.command.device.machine.Television;
import com.designpatterns.command.device.DeviceButton;

public class Client {

    public static void main(String[] args) {
        Television tv = new Television();
        Radio radio = new Radio();

        TurnTvOn tvOn = new TurnTvOn(tv);
        TurnTvOff tvOff = new TurnTvOff(tv);
        TurnTvVolumeUp tvVolUp = new TurnTvVolumeUp(tv);
        TurnTvVolumeDown tvVolDown = new TurnTvVolumeDown(tv);

        TurnRadioOn radioOn = new TurnRadioOn(radio);
        TurnRadioOff radioOff = new TurnRadioOff(radio);
        TurnRadioVolUp radioVolUp = new TurnRadioVolUp(radio);
        TurnRadioVolDown radioVolOff = new TurnRadioVolDown(radio);

        DeviceButton tvOnButton = new DeviceButton(tvOn);
        DeviceButton tvOffButton = new DeviceButton(tvOff);
        DeviceButton tvVolUpButton = new DeviceButton(tvVolUp);
        DeviceButton tvVolDownButton = new DeviceButton(tvVolDown);

        DeviceButton radioOnButton = new DeviceButton(radioOn);
        DeviceButton radioOffButton = new DeviceButton(radioOff);
        DeviceButton radioVolUpButton = new DeviceButton(radioVolUp);
        DeviceButton radioVolDownButton = new DeviceButton(radioVolOff);

        tvOnButton.press();
        tvOffButton.press();
        tvVolUpButton.press();
        tvVolDownButton.press();
        tvVolDownButton.press();

        radioOnButton.press();
        radioOffButton.press();
        radioVolUpButton.press();
        radioVolDownButton.press();
    }

}
