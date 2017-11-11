package org.firstinspires.ftc.teamcodepromo.systems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcodepromo.hardwareDefinition.HvaHardwarePushbot;

public class Gripper {

    private HvaHardwarePushbot bot;
    private boolean positionOpen;
    private boolean pressed;
    private Gamepad gamepad;
    // private TouchSensor touchSensor;  // Hardware Device Object

    public Gripper(HvaHardwarePushbot ourBot, Gamepad pad){
        bot = ourBot;
        gamepad = pad;
        pressed = false;
        setStartPosition();
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

        // if button is JUST pressed
        if (gamepad.right_bumper && !pressed)
        {
            togglePositionOpen();
            pressed = true;
        }
        // if button is NOT pressed
        else if (!gamepad.right_bumper)
        {
            pressed = false;

            // if the touch sensor detects a block, then close the gripper
//            if(bot.touchSensor.isPressed()){
//                setPositionOpen(false);
//            }
//            else{
//                setPositionOpen(true);
//            }
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
        return bot.rightFinger.getPosition();
    }
}