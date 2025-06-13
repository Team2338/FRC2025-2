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
        Robot.arm.farShootPosition();
        Robot.algaeShooterRight.setFarShootRPM();
        Robot.algaeShooter.setFarShootRPM();
    }


    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.algaeShooter.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        Robot.algaeShooterRight.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_FAR);
        if((Robot.algaeShooter.getRPM()>Constants.FAR_SHOOT_RPM)&&(Robot.algaeShooterRight.getRPM()>Constants.FAR_SHOOT_RPM)&&(0.220<=Robot.arm.getPosition()&&Robot.arm.getPosition()<=0.320)){
            Robot.algaeShooterIndexer.turnmotor(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX_FAR);
            Robot.algaeShooterIndexer2.turnmotor(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX_FAR);}
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.algaeShooter.setVoltage(0);
        Robot.algaeShooterRight.setVoltage(0);
        Robot.algaeShooterIndexer.turnmotor(0);
        Robot.algaeShooterIndexer2.turnmotor(0);

    }
}
