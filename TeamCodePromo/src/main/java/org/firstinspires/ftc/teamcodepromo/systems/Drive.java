package org.firstinspires.ftc.teamcodepromo.systems;

import org.firstinspires.ftc.teamcodepromo.hardwareDefinition.HvaHardwarePushbot;

/**
 * Created by robert on 11/8/17.
 */

public class Drive {
    private HvaHardwarePushbot bot;
    private boolean orientForward;

    public enum Direction {CCW, CW};

    public Drive(HvaHardwarePushbot ourBot){
        bot = ourBot;
        orientForward = false;
    }

    public void circle(Direction dir){
        if(dir == Direction.CW){
            // drive Clockwise - left wheels FASTER than right wheels
            // the greater the difference the tighter the circle
            bot.leftMotor.setPower(-1.0);
            bot.rightMotor.setPower(-0.0);
        }
        else{
            // drive Counter-Clockwise - left wheels SLOWER than right wheels
            bot.leftMotor.setPower(-0.0);
            bot.rightMotor.setPower(-1.0);
        }
    }

    public void tank(double left, double right){
        if(orientForward)
        {
            // Joystick is NEGATIVE when pushed forward, so negate
            bot.leftMotor.setPower(-left);
            bot.rightMotor.setPower(-right);
        }
        else
        {
            bot.leftMotor.setPower(right);
            bot.rightMotor.setPower(left);
        }
    }
}
