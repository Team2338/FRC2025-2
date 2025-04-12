// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.Algae;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class AlgaeLimitSwitch extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    private static DigitalInput LimitSwitch;

    public AlgaeLimitSwitch() {
        LimitSwitch = new DigitalInput (RobotMap.ALGAE_LIMIT_SWITCH_ID);
    }

    public boolean getState() {
        return LimitSwitch.get();
    }

    public void addtoShuffleboard(String tabName, String widgetTitle){
    ShuffleboardTab tab = Shuffleboard.getTab(tabName); //gets a reference to the shuffleboard tab
        tab.add(widgetTitle, (x) -> {
        x.setSmartDashboardType("Boolean Box");
        x.addBooleanProperty("Value", this::getState, null);
    });
}


}




