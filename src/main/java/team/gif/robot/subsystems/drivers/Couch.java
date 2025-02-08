// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.drivers;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

import static team.gif.robot.subsystems.HamBurger.config;

public class Couch extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public static SparkMax couch;
  public Couch() {
    couch = new SparkMax(RobotMap.COUCH_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    couch.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.signals.primaryEncoderPositionPeriodMs(5); //i'm not sure if we need this
    config.idleMode(SparkBaseConfig.IdleMode.kBrake);

  }
  public void turnmotor(double voltage) {
    couch.setVoltage(voltage);
  }
}
