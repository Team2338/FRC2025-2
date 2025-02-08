// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.drivers;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class Couch extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public static TalonSRX couch;
  public Couch() {
    couch = new TalonSRX(RobotMap.COUCH_NEO_TEST);
    couch.configFactoryDefault();
    couch.setNeutralMode(NeutralMode.Brake);


    /** Creates a new ExampleSubsystem. */


  }
  public void turnmotor(double percentOutput) {
    couch.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }

  
}
