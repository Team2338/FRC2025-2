// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Couch extends SubsystemBase {
  public static SparkMax couch;
  public static SparkMaxConfig config;

  public Couch() {
    couch = new SparkMax(RobotMap.COUCH_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    couch.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);

  }
  public void turnmotor(double voltage) {
    couch.setVoltage(voltage);
  }
}
