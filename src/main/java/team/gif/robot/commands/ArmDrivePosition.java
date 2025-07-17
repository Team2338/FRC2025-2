package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ArmDrivePosition extends Command {

    public ArmDrivePosition() {
        super();
        addRequirements(Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(Robot.arm.isManualArmToggled()){
            Robot.arm.setArmPosition(Constants.ARM_DRIVE_POSITION);
        }
        else
            Robot.arm.holdArmPosition(Constants.ARM_DRIVE_POSITION);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        if (Math.abs(Robot.arm.getPosition() - Constants.ARM_DRIVE_POSITION) <= .20) {
            return true;
        }
        else
            return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //If this doesn't work, then make a default command that just holds the arm at the current position Robot.arm.setArmPosition(Robot.arm.getPosition())
        //Robot.arm.holdArmPosition(Constants.ARM_DRIVE_POSITION);
    }
}
