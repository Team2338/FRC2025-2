package team.gif.robot;

/**
 *   Initialize the shuffleboard here.
 *   Shuffleboard is a modern looking driveteam focused dashboard. It displays network
 *    tables data using a variety of widgets that can be positioned and controlled with robot code.
 *   Helpful link: https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/index.html

 *   Use the variable(shuffleboardTab) to add it to your shuffleboard.
 *   Example: shuffleboardTab.addBoolean("title of widget", Robot.arm::getPos());
 *   There is many more functions that you can use, example addString, addNumber, etc.
 */

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class UI {

    public UI() {
        ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("FRC 2025");
        shuffleboardTab.addDouble("Couch Encoder", Robot.coralDumper::getPosition);
        shuffleboardTab.addDouble("Arm Encoder", Robot.arm::getPosition);
        shuffleboardTab.addDouble("Left RPM", Robot.algaeShooterLeft::getRPM);
        shuffleboardTab.addDouble("Right RPM", Robot.algaeShooterRight::getRPM);
        shuffleboardTab
                .addBoolean("Limit Switch", Robot.algaeLimitSwitch::getState)
                .withWidget(BuiltInWidgets.kBooleanBox);
        shuffleboardTab
                .addDouble("Pigeon Heading", Robot.pigeon::getCompassHeading)
                .withWidget(BuiltInWidgets.kGyro);
    }

}
