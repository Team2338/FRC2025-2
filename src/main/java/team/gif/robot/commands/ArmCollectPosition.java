package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class ArmCollectPosition extends Command {

    public ArmCollectPosition() {
        super();
        addRequirements(Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.arm.collectPosition();
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    //TODO: Use constants
    @Override
    public boolean isFinished() {
        if (Math.abs(Robot.arm.getPosition() - 1.10) <= .02) {
            return true;
        }
        else
            return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
