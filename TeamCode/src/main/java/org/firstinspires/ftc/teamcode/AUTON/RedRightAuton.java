package org.firstinspires.ftc.teamcode.AUTON;//package org.firstinspires.ftc.teamcode.auton.ops;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "ReddRight")
public class RedRightAuton extends CommandOpMode {

    private Motor fL, bL, fR, bR;

    @Override
    public void initialize() {

        fL = new Motor(hardwareMap, "fL");
        fR = new Motor(hardwareMap, "fR");
        bL = new Motor(hardwareMap, "bL");
        bR = new Motor(hardwareMap, "bR");

        bR.motor.setDirection(DcMotor.Direction.REVERSE);
        bL.motor.setDirection(DcMotor.Direction.REVERSE);

        schedule(
                new WaitUntilCommand(this::isStarted)
                        .andThen(new ParallelCommandGroup(
                                new InstantCommand(() -> fL.set(-0.3)),
                                new InstantCommand(() -> bL.set(0.3)),
                                new InstantCommand(() -> fR.set(0.3)),
                                new InstantCommand(() -> bR.set(-0.3))
                        )).andThen(
                                new WaitCommand(2000))
                        .andThen(new ParallelCommandGroup(
                                        new InstantCommand(() -> fL.stopMotor()),
                                        new InstantCommand(() -> bL.stopMotor()) ,
                                        new InstantCommand(() -> fR.stopMotor()),
                                        new InstantCommand(() -> bR.stopMotor())
                                )
                        )
                        .andThen(new ParallelCommandGroup(
                                new InstantCommand(() -> fL.set(0.3)),
                                new InstantCommand(() -> bL.set(-0.3)),
                                new InstantCommand(() -> fR.set(-0.3)),
                                new InstantCommand(() -> bR.set(0.3))
                        )).andThen(
                                new WaitCommand(700))
                        .andThen(new ParallelCommandGroup(
                                        new InstantCommand(() -> fL.stopMotor()),
                                        new InstantCommand(() -> bL.stopMotor()) ,
                                        new InstantCommand(() -> fR.stopMotor()),
                                        new InstantCommand(() -> bR.stopMotor())
                                )
                        ).andThen(new ParallelCommandGroup(
                                new InstantCommand(() -> fL.set(-0.3)),
                                new InstantCommand(() -> bL.set(-0.3)),
                                new InstantCommand(() -> fR.set(-0.3)),
                                new InstantCommand(() -> bR.set(-0.3))
                        )).andThen(

                                new WaitCommand(3000))
                        .andThen(new ParallelCommandGroup(
                                new InstantCommand(() -> fL.stopMotor()),
                                new InstantCommand(() -> bL.stopMotor()) ,
                                new InstantCommand(() -> fR.stopMotor()),
                                new InstantCommand(() -> bR.stopMotor())
                        )).andThen(new ParallelCommandGroup(
                                new InstantCommand(() -> fL.set(-0.3)),
                                new InstantCommand(() -> bL.set(0.3)),
                                new InstantCommand(() -> fR.set(0.3)),
                                new InstantCommand(() -> bR.set(-0.3))
                        )).andThen(
                                new WaitCommand(800))

                        .andThen(new ParallelCommandGroup(
                                new InstantCommand(() -> fL.stopMotor()),
                                new InstantCommand(() -> bL.stopMotor()) ,
                                new InstantCommand(() -> fR.stopMotor()),
                                new InstantCommand(() -> bR.stopMotor())

                                        .andThen(new ParallelCommandGroup(
                                        new InstantCommand(() -> fL.set(-0.3)),
                                        new InstantCommand(() -> bL.set(-0.3)),
                                        new InstantCommand(() -> fR.set(-0.3)),
                                        new InstantCommand(() -> bR.set(-0.3))
                                )).andThen(

                                        new WaitCommand(650))

                                        .andThen(new ParallelCommandGroup(
                                                new InstantCommand(() -> fL.stopMotor()),
                                                new InstantCommand(() -> bL.stopMotor()) ,
                                                new InstantCommand(() -> fR.stopMotor()),
                                                new InstantCommand(() -> bR.stopMotor()))))));


    }
}



