package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class HamBurgerIndex2 extends Command {

    public HamBurgerIndex2() {
        super();
        addRequirements(Robot.hamBurgerIndexer2);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.hamBurgerIndexer2.turnmotor(-Constants.HAM_BURGER_INDEX_TALON_PERCENT);

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.hamBurgerIndexer2.turnmotor(0);

    }
}
