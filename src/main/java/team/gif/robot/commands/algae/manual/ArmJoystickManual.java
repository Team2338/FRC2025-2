package team.gif.robot.commands.algae.manual;

import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import team.gif.robot.Robot;

public class ArmJoystickManual extends Command {

    public ArmJoystickManual() {
        super();
        addRequirements(Robot.arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
//        if(Robot.arm.isManualArmToggled()){
//            double voltage = Robot.oi.aux.getLeftY();
//            Robot.arm.setVoltage(voltage*6);
//        }
        Robot.oi.driver.leftTrigger().whileTrue(new InstantCommand(() -> Robot.arm.setVoltage(-2)).withTimeout(0.2));
        Robot.oi.driver.rightTrigger().whileTrue(new InstantCommand(() -> Robot.arm.setVoltage(2)).withTimeout(0.2));
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
