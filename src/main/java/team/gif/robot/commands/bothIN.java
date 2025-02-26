package team.gif.robot.commands;
/**
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class bothIN extends Command {

    public bothIN(){
        super();
        addRequirements(Robot.algaeShooter,Robot.algaeShooterRight,Robot.algaeShooterIndexer2,Robot.algaeShooterIndexer);

    }


        //addRequirements(Robot.climber); // uncomment


        // Called when the command is initially scheduled.
        @Override
        public void initialize() {}

        // Called every time the scheduler runs (~20ms) while the command is scheduled
        @Override
        public void execute() {
        Robot.algaeShooter.turnmotor(Constants.ALGAE_SHOOTER_IN);
        Robot.algaeShooterRight.turnmotor(-Constants.ALGAE_SHOOTER_IN);
        Robot.algaeShooterIndexer2.turnmotor(Constants.ALGAE_SHOOTER_IN);
        Robot.algaeShooterIndexer.turnmotor(-Constants.ALGAE_SHOOTER_IN);
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

*/