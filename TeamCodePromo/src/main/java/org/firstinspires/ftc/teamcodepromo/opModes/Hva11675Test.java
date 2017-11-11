/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcodepromo.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcodepromo.hardwareDefinition.*;
import org.firstinspires.ftc.teamcodepromo.systems.*;

/**
 * This file provides basic Telop driving for a Pushbot robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 *
 * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="HVA Promo Teleop Tank", group="HVA")

public class Hva11675Test extends OpMode{

    /* Declare OpMode members. */
    HvaHardwarePushbot robot       = new HvaHardwarePushbot(); // use the class created to define a Pushbot's hardware
    Gripper gripper = null;
    Drive drive = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        gripper = new Gripper(robot);
        drive = new Drive(robot);

        // Send telemetry message to signify robot waiting
        telemetry.addData("Say", "Hello Mister Ben");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double left = 0;
        double right = 0;


        // Use gamepad right Bumpers toggles finger open/closed
        if (gamepad1.right_bumper)
            gripper.togglePositionOpen();

        // The gripper will automatically close if needed (i.e. if the touch sensor is active)
        gripper.update();

        if(gamepad1.dpad_right){
            drive.circle(Drive.Direction.CW);
        }
        else if(gamepad1.dpad_left){
            drive.circle(Drive.Direction.CCW);
        }
        else{
            // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            drive.tank(left, right);
        }

        // Use gamepad buttons to move the arm up (Y) and down (A)
//        if (gamepad2.y)
//            robot.armMotor.setPower(robot.ARM_UP_POWER);
//        else if (gamepad2.a)
//            robot.armMotor.setPower(robot.ARM_DOWN_POWER);
//        else
//            robot.armMotor.setPower(0.0);

        // Use gamepad buttons Y(up) and A(down)
        if (gamepad1.y)
            robot.armMotor.setPower(robot.ARM_UP_POWER);
        else if (gamepad1.a)
            robot.armMotor.setPower(robot.ARM_DOWN_POWER);
        else
            robot.armMotor.setPower(0.0);

        // gamepad1 buttons X(in) and B(out)
        if (gamepad1.x)
            robot.intakeMotor.setPower(robot.INTAKE_IN_POWER);
        else if (gamepad1.b)
            robot.intakeMotor.setPower(robot.INTAKE_OUT_POWER);
        else
            robot.intakeMotor.setPower(0.0);

        // Send telemetry message to signify robot running;
        telemetry.addData("finger",  "Servo Left Pos = %.2f, Servo Right Pos = %.2f", gripper.getLeftPosition(), gripper.getRightPosition());
        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
