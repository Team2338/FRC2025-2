package team.gif.robot.commands.algae.shoot;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ManualAlgaeShooterShootFarther extends Command {
private int runs;
    public ManualAlgaeShooterShootFarther() {
        super();
        addRequirements(Robot.algaeShooterLeft,Robot.algaeShooterRight,Robot.algaeShooterIndexer,Robot.algaeShooterIndexer2,Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.algaeShooterLeft.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        Robot.algaeShooterRight.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        Robot.algaeShooterIndexer.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX_FAR);
        Robot.algaeShooterIndexer2.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX_FAR);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.algaeShooterLeft.setVoltage(0);
        Robot.algaeShooterRight.setVoltage(0);
        Robot.algaeShooterIndexer.setVoltage(0);
        Robot.algaeShooterIndexer2.setVoltage(0);

    }
}
