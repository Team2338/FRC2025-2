// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel;
import team.gif.robot.commands.AlgaeShooterIndex2;

public class AlgaeShooterIndexer2 extends SubsystemBase {
  public static SparkMax AlgaeShooterIndex2;
  public static SparkMaxConfig config;

  public AlgaeShooterIndexer2() {
   // AlgaeShooterIndex2 = new SparkMax(RobotMap.ALGAE_SHOOTER_NEO_INDEX2, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    AlgaeShooterIndex2.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
  }
  public void turnmotor(double voltage){
    AlgaeShooterIndex2.setVoltage(voltage);
  }
}