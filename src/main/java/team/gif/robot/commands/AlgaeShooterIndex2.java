package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterIndex2 extends Command {

    public AlgaeShooterIndex2() {
        super();
       // addRequirements(Robot.algaeShooterIndexer2);
        //addRequirements(Robot.climber); // uncomment
    }

    public static void setVoltage(double voltage) {

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        //Robot.algaeShooterIndexer2.turnmotor(Constants.ALGAE_SHOOTER_INDEX_NEO_PERCENT);
        //Robot.algaeShooterIndexer2.turnmotor(-Constants.ALGAE_SHOOTER_INDEX_NEO_PERCENT);


    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //Robot.algaeShooterIndexer2.turnmotor(0);

    }
}
