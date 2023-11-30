package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.R;

@TeleOp(name = "MotorTest")
public class MotorTest extends CommandOpMode {

    private Motor test;
    private GamepadEx gPad1;

    @Override
    public void initialize() {


        test = new Motor(hardwareMap, "test");

        gPad1 = new GamepadEx(gamepad1);






        gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(new StartEndCommand(() -> test.set(0.35), () -> test.stopMotor()));
        gPad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new StartEndCommand(() -> test.set(-0.35), () -> test.stopMotor()));

        test.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);


    }
}












//gPad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
//     new RunCommand(() -> airServo.setPosition(0)));// new RunCommand(() -> airServo.turnToAngle(270)));

//gPad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
//       new RunCommand(() -> airServo.setPosition(0.5)));

//        gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed( //------------------------------------WORKS.THIS.WORKS
//                new RunCommand(() -> airServo.setPosition(1)));

//        gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
//                new InstantCommand(() -> airServo.setPosition(1));//, new InstantCommand(() -> airServo.setPosition(0)));

       /*gPad1.getGamepadButton(GamepadKeys.Button.A).whileHeld(
                new RunCommand(() -> airServo.setPosition(0)));// new RunCommand(() -> airServo.turnToAngle(270)));

        gPad1.getGamepadButton(GamepadKeys.Button.B).whileHeld(
                new RunCommand(() -> airServo.setPosition(1)));*/


//gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new InstantCommand(() -> airServo.rotateByAngle(90))
//      .andThen(new InstantCommand(() -> airServo.rotateByAngle(90))));

// gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(new StartEndCommand(() -> intake.set(1), () -> intake.stopMotor()));