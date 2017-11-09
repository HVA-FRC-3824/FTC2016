package org.firstinspires.ftc.teamcodepromo.systems;

import org.firstinspires.ftc.teamcodepromo.hardwareDefinition.HvaHardwarePushbot;

/**
 * Created by robert on 11/8/17.
 */

public class Drive {
    private HvaHardwarePushbot bot;

    public enum Direction {CCW, CW};

    public Drive(HvaHardwarePushbot ourBot){
        bot = ourBot;
    }

    public void circle(Direction dir){
        if(dir == Direction.CW){
            // drive Clockwise - left wheels FASTER than right wheels
            // the greater the difference the tighter the circle
            bot.leftMotor.setPower(0.5);
            bot.rightMotor.setPower(0.25);
        }
        else{
            // drive Counter-Clockwise - left wheels SLOWER than right wheels
            bot.leftMotor.setPower(0.25);
            bot.rightMotor.setPower(0.5);
        }
    }

    public void tank(double left, double right){
        bot.leftMotor.setPower(left);
        bot.rightMotor.setPower(right);
    }
}
