package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.coralDumper;

public class CoralCollectAuto extends Command {
    public int time;
    public int timer;
    public CoralCollectAuto() {
        super();
        addRequirements(Robot.coralDumper,Robot.driveTrain,Robot.arm); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {time = 0;
        timer = 0;
        Robot.arm.setArmPosition(Constants.ARM_DRIVE_POSITION);
        System.out.println("Auto started");

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(time <= 50){
            time += 1;
            Robot.driveTrain.driveArcade(0,-.6);
        }
        if(time > 50){
            Robot.driveTrain.driveArcade(0,0);
            timer+=1;
            if(timer<50){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT_AUTOS);}
            if(timer>=50){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT_AUTOS);}
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return timer>95;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.coralDumper.setVoltage(0);
    }
}
