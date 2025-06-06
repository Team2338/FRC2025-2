// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.Algae.shooter;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkLowLevel;

public class AlgaeShooterRight extends SubsystemBase {

  public static SparkFlex algaeShooterRight;
  public static SparkFlexConfig config;

  public AlgaeShooterRight() {
//    algaeShooterRight = new SparkFlex(RobotMap.ALGAE_SHOOTER_NEO_RIGHT, SparkLowLevel.MotorType.kBrushless);
//    config = new SparkFlexConfig();
//    algaeShooterRight.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
//    config.idleMode(SparkFlexConfig.IdleMode.kBrake);

  }
  public void turnmotor(double voltage){
//    algaeShooterRight.setVoltage(voltage);
  }


}
