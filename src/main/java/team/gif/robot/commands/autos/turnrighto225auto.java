package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class turnrighto225auto extends Command {
    public turnrighto225auto() {
        super();
        addRequirements(Robot.coralDumper,Robot.driveTrain); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
            Robot.driveTrain.driveArcade(0.6,0);
        }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished(){
        return Robot.pigeon.get360Heading() > (170) && Robot.pigeon.get360Heading() < (190);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrain.driveArcade(0,0);
        System.out.println("turn finished");
    }}
