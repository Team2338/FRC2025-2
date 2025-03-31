package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.coralDumper;

public class DriveForwardAuto extends Command {
    public int time;
    public int timer;
    public DriveForwardAuto() {
        super();
        addRequirements(Robot.coralDumper,Robot.driveTrain); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {time = 0;
        timer = 0;
        System.out.println("Auto started");
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(time <= 50){
            time += 1;
            Robot.driveTrain.driveArcade(.5,0);
        }
        if(time > 50){
            Robot.driveTrain.driveArcade(0,0);
            timer+=1;
            if(timer<60){coralDumper.turnmotor(Constants.CORAL_NEO_PERCENT);}
            if(timer>=60){coralDumper.turnmotor(-Constants.CORAL_NEO_PERCENT);}
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        if(timer>110){return true;}
        else{return false;}
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.coralDumper.turnmotor(0);
        System.out.println("Auto ended");

    }
}
