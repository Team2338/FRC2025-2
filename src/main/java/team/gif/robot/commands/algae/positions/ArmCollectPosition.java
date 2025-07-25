package team.gif.robot.commands.algae.positions;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
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
        if(Robot.arm.isManualArmToggled()){
            Robot.arm.setArmPosition(Constants.ARM_COLLECT_POSITION);
        }
        else Robot.arm.holdArmPosition(Constants.ARM_COLLECT_POSITION);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return Math.abs(Robot.arm.getPosition() - Constants.ARM_COLLECT_POSITION) <= Constants.ARM_POSITION_TOLERANCE;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //Robot.arm.holdArmPosition(Constants.ARM_DRIVE_POSITION);
    }
}
