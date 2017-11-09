package org.firstinspires.ftc.teamcodepromo.systems;

import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcodepromo.hardwareDefinition.HvaHardwarePushbot;

public class Gripper {

    private HvaHardwarePushbot bot;
    private boolean positionOpen;
    private TouchSensor touchSensor;  // Hardware Device Object

    public Gripper(HvaHardwarePushbot ourBot){
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

    public void update(){
        // if the touch sensor detects a block, then close the gripper
        if(bot.touchSensor.isPressed()){
            setPositionOpen(false);
        }
        else{
            setPositionOpen(true);
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