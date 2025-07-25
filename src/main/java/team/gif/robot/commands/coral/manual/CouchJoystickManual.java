package team.gif.robot.commands.coral.manual;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class CouchJoystickManual extends Command {

    public CouchJoystickManual() {
        super();
        addRequirements(Robot.coralDumper);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double voltage = Robot.oi.aux.getRightY();
        Robot.coralDumper.setVoltage(voltage);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
