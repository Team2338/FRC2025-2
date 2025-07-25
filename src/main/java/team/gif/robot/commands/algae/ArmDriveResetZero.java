package team.gif.robot.commands.algae;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class ArmDriveResetZero extends Command {

    public ArmDriveResetZero() {
        super();
        addRequirements(Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.arm.zeroEncoder();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {}

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
