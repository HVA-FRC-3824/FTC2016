package org.firstinspires.ftc.teamcodepromo.systems;

import org.firstinspires.ftc.teamcodepromo.hardwareDefinition.HvaHardwarePushbot;

public class Finger {

    private HvaHardwarePushbot bot;
    private boolean positionOpen;

    public Finger(HvaHardwarePushbot ourBot){
        bot = ourBot;
    }

    public void setStartPosition(){
        setPositionOpen(true);
    }

    public void setPositionOpen(boolean flag){
        if(flag == true){
            bot.leftFinger.setPosition(HvaHardwarePushbot.LEFT_FINGER_OPEN);
            bot.rightFinger.setPosition(HvaHardwarePushbot.RIGHT_FINGER_OPEN);
            positionOpen = true;
        }
        else{
            bot.leftFinger.setPosition(HvaHardwarePushbot.LEFT_FINGER_CLOSED);
            bot.rightFinger.setPosition(HvaHardwarePushbot.RIGHT_FINGER_CLOSED);
            positionOpen = false;
        }
    }

    public boolean getPositionOpen(){
        return positionOpen;
    }

    public void togglePositionOpen(){
        setPositionOpen(!getPositionOpen());
    }

    public double getLeftPosition(){
        return bot.leftFinger.getPosition();
    }

    public double getRightPosition(){
        return bot.leftFinger.getPosition();
    }
}