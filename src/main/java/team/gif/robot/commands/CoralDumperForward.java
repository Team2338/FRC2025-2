package team.gif.robot.commands;
/**
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.coralDumper;

public class CoralDumperForward extends Command {

    public CoralDumperForward() {
        super();
        addRequirements(coralDumper);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        coralDumper.turnmotor(Constants.CORAL_NEO_PERCENT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return  false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.coralDumper.turnmotor(0);

    }
}
*/