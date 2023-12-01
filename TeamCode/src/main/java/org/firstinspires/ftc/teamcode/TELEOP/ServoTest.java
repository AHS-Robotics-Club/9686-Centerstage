package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.R;

@TeleOp(name = "ServoTest")
public class ServoTest extends CommandOpMode {
    private SimpleServo airServo;

    private GamepadEx gPad1;

    @Override
    public void initialize() {
        airServo = new SimpleServo(hardwareMap, "air",-180,180);
        gPad1 = new GamepadEx(gamepad1);

//       gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed
//                 (
//                        new InstantCommand(() -> airServo.setPosition(0))
//                        .andThen(new InstantCommand(() -> airServo.setPosition(1))));


        gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new InstantCommand(() -> airServo.setPosition(1)).andThen(new WaitCommand(1000))
      .andThen(new InstantCommand(() -> airServo.setPosition(0.4))));



        schedule(new RunCommand(() -> {
            telemetry.addData("AirplaneSERVOANLE", airServo.getAngle());
            telemetry.update();
        }));
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