package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class HamBurgerShoot extends Command {
private int runs;
    public HamBurgerShoot() {
        super();
        addRequirements(Robot.hamBurger);
        addRequirements(Robot.hamBurgerRight);
        addRequirements(Robot.hamBurgerIndexer);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {runs = 0;}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        runs++;
        double hamBurgerPercent = Constants.HAM_BURGER_TALON_PERCENT;
        Robot.hamBurger.turnmotor(hamBurgerPercent);
        if(runs>100){
            Robot.hamBurgerIndexer.turnmotor(Constants.HAM_BURGER_INDEX_TALON_PERCENT);
        }
        Robot.hamBurger.turnmotor(Constants.HAM_BURGER_TALON_PERCENT);
        Robot.hamBurgerRight.turnmotor(-Constants.HAM_BURGER_TALON_PERCENT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.hamBurger.turnmotor(0);
        Robot.hamBurgerRight.turnmotor(0);
        Robot.hamBurgerIndexer.turnmotor(0);

    }
}
