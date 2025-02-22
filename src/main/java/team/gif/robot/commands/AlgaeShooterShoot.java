package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterShoot extends Command {
private int runs;
    public AlgaeShooterShoot() {
        super();
        addRequirements(Robot.algaeShooter,Robot.algaeShooterRight,Robot.algaeShooterIndexer,Robot.algaeShooterIndexer2);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        runs=0;
    }


    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        runs++;
        Robot.algaeShooter.turnmotor(-Constants.ALGAE_SHOOTER_NEO_PERCENT);
        Robot.algaeShooterRight.turnmotor(Constants.ALGAE_SHOOTER_NEO_PERCENT);
        if(runs>100){
            Robot.algaeShooterIndexer.turnmotor(Constants.ALGAE_SHOOTER_INDEX_NEO_PERCENT);
            Robot.algaeShooterIndexer2.turnmotor(-Constants.ALGAE_SHOOTER_INDEX_NEO_PERCENT);}
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.algaeShooter.turnmotor(0);
        Robot.algaeShooterRight.turnmotor(0);
        Robot.algaeShooterIndexer.turnmotor(0);
        Robot.algaeShooterIndexer2.turnmotor(0);

    }
}
