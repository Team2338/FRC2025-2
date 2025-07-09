package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class DriveBackwardAuto extends Command {
    public int time;
    public DriveBackwardAuto() {
        super();
        addRequirements(Robot.driveTrain); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {time = 0;
        System.out.println("going backward");

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(time <= 45){
            time += 1;
            Robot.driveTrain.driveArcade(0,.5);
        }
        if(time > 45){
            Robot.driveTrain.driveArcade(0,0);
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return time>45;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrain.driveArcade(0,0);
    }
}
