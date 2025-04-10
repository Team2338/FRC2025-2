package team.gif.robot.commands.drivetrain;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ArcadeDrive extends Command {
    private SlewRateLimiter speedFilter;
    private SlewRateLimiter turnFilter;


    public ArcadeDrive() {
        speedFilter = new SlewRateLimiter(Constants.ARCADE_DRIVE_MAX_ACCELERATION_UNITS_PER_SECOND);
        turnFilter = new SlewRateLimiter(Constants.ARCADE_DRIVE_MAX_TURN_UNITS_PER_SECOND);
        addRequirements(Robot.driveTrain);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double rotation = Robot.oi.driver.getLeftY(); //switch to getLeftX if we were to do one joystick arcade for some reason
        double speed = Robot.oi.driver.getRightX();

        rotation = speedFilter.calculate(rotation) * .8;
        speed = turnFilter.calculate(speed) * .8;

        Robot.driveTrain.driveArcade(speed, rotation); //two joysticks - left controls speed and right controls rotations
        //TODO: Add a boost button
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrain.driveArcade(0,0);
    }
}