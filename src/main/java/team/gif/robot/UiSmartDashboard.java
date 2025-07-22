package team.gif.robot;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.commands.autos.AutosGroup;
import team.gif.robot.commands.autos.DriveForwardAuto;
import team.gif.robot.commands.autos.NoAuto;

public class UiSmartDashboard {

    public SendableChooser<Command> autoChooser = new SendableChooser<>();
    public SendableChooser<Double> delayChooser = new SendableChooser<>();

    /**
     *  Widgets (e.g. gyro),
     *  buttons (e.g. SmartDashboard.putData("Reset", new ResetHeading()); ),
     *  and Chooser options (e.g. auto mode)
     *
     *  Placed on a dashboard tab
     *  After SmartDashboard loads for the first time, items from network table onto Dashboard tab
     *  and save file as "YYYY shuffleboard layout.json"
     */
    public UiSmartDashboard() {
        //ShuffleboardTab tab = Shuffleboard.getTab("SmartDashboard"); // Gets a reference to the shuffleboard tab
        autoChooser.setDefaultOption("No Auto", new NoAuto());
        autoChooser.addOption("Center 1pc", new DriveForwardAuto());
        autoChooser.addOption("Center 2pc Left Side", new AutosGroup());
        SmartDashboard.putData("Auto", autoChooser);

        delayChooser.setDefaultOption("0", 0.0);
        delayChooser.addOption("1", 1.0);
        delayChooser.addOption("2", 2.0);
        delayChooser.addOption("3", 3.0);
        delayChooser.addOption("4", 4.0);
        delayChooser.addOption("5", 5.0);
        SmartDashboard.putData("Delay", delayChooser);
    }

    /**
     * Values which are updated periodically should be placed here
     *
     * Convenient way to format a number is to use putString w/ format:
     *     SmartDashboard.putString("Elevator", String.format("%11.2f", Elevator.getPosition()));
     */
    public void updateUI() {
        SmartDashboard.putNumber("Heading", Robot.pigeon.getCompassHeading());
        SmartDashboard.putNumber("Match Time", Robot.matchTime);
        SmartDashboard.putNumber("Voltage", RobotController.getBatteryVoltage());
        SmartDashboard.putNumber("Arm Position", Robot.arm.getPosition());
        SmartDashboard.putBoolean("Manual Arm Toggled", Robot.arm.isManualArmToggled());
        SmartDashboard.putBoolean("Intake Limit Switch Toggled", Robot.algaeLimitSwitch.getState());
        SmartDashboard.putNumber("Left Shooter Motor RPM", Robot.algaeShooterLeft.getRPM());
        SmartDashboard.putNumber("Right Shooter Motor RPM", Robot.algaeShooterRight.getRPM());
        SmartDashboard.putNumber("Coral Dumper Position", Robot.coralDumper.getPosition());
    }
}
