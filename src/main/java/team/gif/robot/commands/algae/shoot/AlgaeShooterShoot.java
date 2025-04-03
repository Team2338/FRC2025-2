package team.gif.robot.commands.algae.shoot;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterShoot extends Command {

    public AlgaeShooterShoot() {
        super();
        addRequirements(Robot.algaeShooter,Robot.algaeShooterRight,Robot.algaeShooterIndexer,Robot.algaeShooterIndexer2,Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.arm.closeShootPosition();
        Robot.algaeShooterRight.setCloseShootRPM();
        Robot.algaeShooter.setCloseShootRPM();
        System.out.println("New Try");
    }


    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.algaeShooter.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_CLOSE);
        Robot.algaeShooterRight.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_CLOSE);
        if((Robot.algaeShooter.getRPM()>Constants.CLOSE_SHOOT_RPM)&&(Robot.algaeShooterRight.getRPM()>Constants.CLOSE_SHOOT_RPM)){
            System.out.println("Left RPM:");
            System.out.println(Robot.algaeShooter.getRPM());
            System.out.println("Right RPM:");
            System.out.println(Robot.algaeShooterRight.getRPM());
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
        Robot.algaeShooter.setVoltage(0);
        Robot.algaeShooterRight.setVoltage(0);
        Robot.algaeShooterIndexer.turnmotor(0);
        Robot.algaeShooterIndexer2.turnmotor(0);

    }
}
