package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.CommandOpMode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.COMMANDS.TestCommand;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.TestSubsystem;


@TeleOp(name = "DriveOnlyTeleOp")
public class DriveOnlyTeleOp extends CommandOpMode {
    private Motor frontLeft, frontRight, backLeft, backRight;


    private TestSubsystem system;

    private TestCommand command;


    private GamepadEx gPad1;

    @Override
    public void initialize() {
        frontLeft = new Motor(hardwareMap, "fL");
        frontRight = new Motor(hardwareMap, "fR");
        backLeft = new Motor(hardwareMap, "bL");
        backRight = new Motor(hardwareMap, "bR");


        gPad1 = new GamepadEx(gamepad1);


        //frontLeft.motor.setDirection(DcMotor.Direction.REVERSE);
        //backLeft.motor.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);




        frontLeft.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        system = new TestSubsystem(frontLeft, frontRight, backLeft, backRight);
        command = new TestCommand(system, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX);

        register(system);
        system.setDefaultCommand(command);


    }
}
