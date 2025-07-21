package team.gif.robot.commands.algae.shoot;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AlgaeShooterIn extends Command {

    public AlgaeShooterIn(){
        super();
        addRequirements(Robot.algaeShooterLeft);
        addRequirements(Robot.algaeShooterRight);
    }


        //addRequirements(Robot.climber); // uncomment


        // Called when the command is initially scheduled.
        @Override
        public void initialize() {}

        // Called every time the scheduler runs (~20ms) while the command is scheduled
        @Override
        public void execute() {
        Robot.algaeShooterLeft.setVoltage(-Constants.ALGAE_SHOOTER_NEO_VOLTAGE_INDEX);
        Robot.algaeShooterRight.setVoltage(Constants.ALGAE_SHOOTER_NEO_VOLTAGE_CLOSE);
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

    }
    }

