package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterProcessorShoot extends Command {
private int runs;
    public AlgaeShooterProcessorShoot() {
        super();
        addRequirements(Robot.algaeShooterLeft,Robot.algaeShooterRight,Robot.algaeShooterIndexer,Robot.algaeShooterIndexer2,Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        //Robot.arm.processorShootPosition();
        Robot.arm.setArmPosition(Constants.ARM_PROCESSOR_SHOOT_POSITION_IN_RADIANS);
    }


    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        /*Robot.algaeShooterLeft.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_PROCESSOR);
        Robot.algaeShooterRight.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_PROCESSOR);*/
        Robot.algaeShooterRight.setRPM(Constants.PROCESSOR_SHOOT_RPM);
        Robot.algaeShooterLeft.setRPM(Constants.PROCESSOR_SHOOT_RPM);

        if (Robot.algaeShooterLeft.atRPM(Constants.PROCESSOR_SHOOT_RPM) &&
                Robot.algaeShooterRight.atRPM(Constants.PROCESSOR_SHOOT_RPM) &&
                Robot.arm.atSetpoint(Constants.ARM_PROCESSOR_SHOOT_POSITION_IN_RADIANS)) {

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
