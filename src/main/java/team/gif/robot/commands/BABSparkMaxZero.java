package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class BABSparkMaxZero extends Command {

    public BABSparkMaxZero() {
        super();
        addRequirements(Robot.babTestSpark);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.babTestSpark.zeroEncoder();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return true;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
