// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class AlgaeShooter extends SubsystemBase {
  private static TalonSRX cimMotor1;
  private static TalonSRX cimMotor2;

  public AlgaeShooter() {
    cimMotor1 = new TalonSRX(RobotMap.ALGAE_TALON);
    cimMotor2 = new TalonSRX(RobotMap.ALGAE_TALON_SECONDARY);

    cimMotor1.configFactoryDefault();
    cimMotor2.configFactoryDefault();

    cimMotor1.setNeutralMode(NeutralMode.Brake);
    cimMotor2.setNeutralMode(NeutralMode.Brake);
  }

  public static void algaeSpeedForward(Double percentOutput){
    cimMotor1.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }
  public static void algaeSpeedReverse(Double percentOutput){
    cimMotor2.set(TalonSRXControlMode.PercentOutput, -percentOutput); //I don't know if the - actually reverses the motor
  }

  
}
