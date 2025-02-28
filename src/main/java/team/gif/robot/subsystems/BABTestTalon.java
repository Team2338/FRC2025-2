// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class BABTestTalon extends SubsystemBase {
  public static TalonSRX cimMotor;

  public BABTestTalon() {
    cimMotor = new TalonSRX(RobotMap.TEST_TALON_ID);
    cimMotor.configFactoryDefault();
    cimMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void setPercent(Double percentOutput){
    cimMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }

}
