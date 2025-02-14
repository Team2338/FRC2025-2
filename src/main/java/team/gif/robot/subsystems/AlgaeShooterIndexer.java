// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel;
import team.gif.robot.commands.AlgaeShooterIndex;

public class AlgaeShooterIndexer extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public static SparkMax algaeShooterIndex;
  public static SparkMaxConfig config;

  public AlgaeShooterIndexer() {
    algaeShooterIndex = new SparkMax(RobotMap.ALGAE_SHOOTER_NEO_LEFT, SparkLowLevel.MotorType.kBrushless);
    algaeShooterIndex.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.signals.primaryEncoderPositionPeriodMs(5); //i'm not sure if we need this
    config = new SparkMaxConfig();
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
  }
  public void turnmotor(double voltage){
    algaeShooterIndex.setVoltage(voltage);
  }

}