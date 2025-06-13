package team.gif.robot.commands.algae.shoot;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterShootFarther extends Command {
private int runs;
    public AlgaeShooterShootFarther() {
        super();
        addRequirements(Robot.algaeShooterLeft,Robot.algaeShooterRight,Robot.algaeShooterIndexer,Robot.algaeShooterIndexer2,Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        //Robot.arm.farShootPosition();
        Robot.arm.setArmPosition(Constants.ARM_FAR_SHOOT_POSITION_IN_RADIANS);
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        /*Robot.algaeShooterLeft.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        Robot.algaeShooterRight.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);*/
        Robot.algaeShooterRight.setRPM(Constants.FAR_SHOOT_RPM);
        Robot.algaeShooterLeft.setRPM(Constants.FAR_SHOOT_RPM);

        if (Robot.algaeShooterLeft.atRPM(Constants.FAR_SHOOT_RPM) &&
                Robot.algaeShooterRight.atRPM(Constants.FAR_SHOOT_RPM) &&
                Robot.arm.atSetpoint(Constants.ARM_FAR_SHOOT_POSITION_IN_RADIANS)) {

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
        /*Robot.algaeShooterLeft.setVoltage(0);
        Robot.algaeShooterRight.setVoltage(0);*/
        Robot.algaeShooterLeft.setRPM(0);
        Robot.algaeShooterRight.setRPM(0);
        Robot.algaeShooterIndexer.turnmotor(0);
        Robot.algaeShooterIndexer2.turnmotor(0);

    }
}
