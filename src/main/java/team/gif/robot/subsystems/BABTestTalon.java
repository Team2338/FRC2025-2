// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
    cimMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute,0,10); //might be relative?
    cimMotor.setSelectedSensorPosition(0,0,10); //reset to 0
    cimMotor.setSensorPhase(false); //sets direction pos
    //encoder units (4096) to degrees (360)
    //private final double Degrees = 360.0/4096;
  }

  public void setPercent(Double percentOutput){
    cimMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }

  public double getPosition(){
    return cimMotor.getSelectedSensorPosition(); //would add times degrees to convert to degrees (but i dont think the conversion is accurate)
  }

}