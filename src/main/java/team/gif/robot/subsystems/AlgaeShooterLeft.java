// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel;

import static team.gif.robot.Robot.algaeShooterRight;

public class AlgaeShooterLeft extends SubsystemBase {
  public static SparkFlex algaeShooterLeft;
  public static SparkFlexConfig config;

  public AlgaeShooterLeft() {
    algaeShooterLeft = new SparkFlex(RobotMap.ALGAE_SHOOTER_NEO_LEFT, SparkLowLevel.MotorType.kBrushless);
    config = new SparkFlexConfig();
    algaeShooterLeft.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);

  }
  public void turnmotor(double voltage){
    algaeShooterLeft.setVoltage(voltage);
  }

}


