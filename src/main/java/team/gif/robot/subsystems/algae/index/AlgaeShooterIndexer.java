// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.algae.index;

import com.revrobotics.spark.SparkBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel;

public class AlgaeShooterIndexer extends SubsystemBase {
  public static SparkMax algaeShooterIndex1;
  public static SparkMaxConfig config;

  public AlgaeShooterIndexer() {
    algaeShooterIndex1 = new SparkMax(RobotMap.ALGAE_SHOOTER_NEO_INDEX1, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    algaeShooterIndex1.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
  }
  public void setVoltage(double voltage){
    algaeShooterIndex1.setVoltage(voltage);
  }

}