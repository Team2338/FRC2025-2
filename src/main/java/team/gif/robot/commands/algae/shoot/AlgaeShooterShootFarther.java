package team.gif.robot.commands.algae.shoot;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterShootFarther extends Command {
private int runs;
    public AlgaeShooterShootFarther() {
        super();
        addRequirements(Robot.algaeShooter,Robot.algaeShooterRight,Robot.algaeShooterIndexer,Robot.algaeShooterIndexer2,Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        runs=0;
        Robot.arm.farShootPosition();
    }


    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        runs++;
        Robot.algaeShooter.turnmotor(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        Robot.algaeShooterRight.turnmotor(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        if(runs>66){
            Robot.algaeShooterIndexer.turnmotor(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX);
            Robot.algaeShooterIndexer2.turnmotor(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX);}
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
