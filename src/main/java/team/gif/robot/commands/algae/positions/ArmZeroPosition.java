package team.gif.robot.commands.algae.positions;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ArmZeroPosition extends Command {

    public ArmZeroPosition() {
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
            Robot.arm.setArmPosition(Constants.ARM_ZERO_POSITION);
        }
        else
            Robot.arm.holdArmPosition(Constants.ARM_ZERO_POSITION);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        if (Math.abs(Robot.arm.getPosition() - Constants.ARM_ZERO_POSITION) <= .02) {
            return true;
        }
        else
            return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //Robot.arm.holdArmPosition(Constants.ARM_ZERO_POSITION);

    }
}
