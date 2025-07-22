package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.subsystems.coral.CoralDumper;

import static team.gif.robot.Robot.coralDumper;

public class DriveForwardtocollectAuto extends Command {
    public int time;
    public int timer;
    public DriveForwardtocollectAuto() {
        super();
        addRequirements(Robot.coralDumper,Robot.driveTrain,Robot.arm); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {time = 0;
        timer = 0;
        Robot.arm.zeroEncoder();
        Robot.arm.setArmPosition(Constants.ARM_DRIVE_POSITION);
        System.out.println("Auto started");

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(time <= 30){
            time += 1;
            Robot.driveTrain.driveArcade(0,-.5);
        }
        if(time > 30){
            Robot.driveTrain.driveArcade(0,0);
            timer+=1;
            if(timer<45){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT);}
            if(timer>=45&& timer<75){coralDumper.setVoltage(0);}
            if(timer>=75){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT);}
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return timer>125;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.coralDumper.setVoltage(0);
    }
}
