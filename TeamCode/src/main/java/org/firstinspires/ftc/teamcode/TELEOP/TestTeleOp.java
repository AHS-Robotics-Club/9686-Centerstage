package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.COMMANDS.TestCommand;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.TestSubsystem;
import org.opencv.video.BackgroundSubtractorKNN;

@TeleOp(name = "TestTeleOp")
public class TestTeleOp extends CommandOpMode {
    private Motor frontLeft, frontRight, backLeft, backRight;
    private Motor intake;
    private Motor actuator;

    private SimpleServo airServo;

    private TestSubsystem system;

    private TestCommand command;


    private GamepadEx gPad1;

    @Override
    public void initialize() {
        frontLeft = new Motor(hardwareMap, "fL");
        frontRight = new Motor(hardwareMap, "fR");
        backLeft = new Motor(hardwareMap, "bL");
        backRight = new Motor(hardwareMap, "bR");

        intake = new Motor(hardwareMap, "intake");
        actuator = new Motor(hardwareMap, "act");

        airServo = new SimpleServo(hardwareMap, "air",-180,180);


        gPad1 = new GamepadEx(gamepad1);


        //frontLeft.motor.setDirection(DcMotor.Direction.REVERSE);
        //backLeft.motor.setDirection(DcMotor.Direction.REVERSE);


        frontLeft.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        actuator.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        system = new TestSubsystem(frontLeft, frontRight, backLeft, backRight);
        command = new TestCommand(system, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX);


        /*gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenActive(
                new InstantCommand(() -> intake.set(1)), new InstantCommand(() -> intake.set(0)));
        gPad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).toggleWhenActive(
                new InstantCommand(() -> intake.set(-1)), new InstantCommand(() -> intake.set(0)));
         */

        gPad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new RunCommand(() -> airServo.setPosition(0)));// new RunCommand(() -> airServo.turnToAngle(270)));

        gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                new RunCommand(() -> airServo.setPosition(0.5)));



        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_UP).toggleWhenActive(
                new InstantCommand(() -> actuator.set(1)), new InstantCommand(() -> actuator.set(0)));
        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).toggleWhenActive(
                new InstantCommand(() -> actuator.set(-1)), new InstantCommand(() -> actuator.set(0)));

        gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(new StartEndCommand(() -> intake.set(1), () -> intake.stopMotor()));
        gPad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new StartEndCommand(() -> intake.set(-1), () -> intake.stopMotor()));


        register(system);
        system.setDefaultCommand(command);

        schedule(new RunCommand(() -> {
            telemetry.addData("AirPlaneServoAngle", airServo.getAngle());
            telemetry.update();
        }));


    }
}
