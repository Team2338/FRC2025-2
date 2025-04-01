package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import static team.gif.robot.Robot.coralDumper;

public class CoralDumperCollect extends Command {
private int timer;
    public CoralDumperCollect() {
        super();
        addRequirements(coralDumper);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        coralDumper.setCollectPosition();
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
    public void end(boolean interrupted) {
        coralDumper.setDrivePosition();
    }
}
