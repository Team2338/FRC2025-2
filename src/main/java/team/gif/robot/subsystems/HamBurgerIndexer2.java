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

public class HamBurgerIndexer2 extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public static SparkMax hamBurgerIndex2;
  public static SparkMaxConfig config;

  public HamBurgerIndexer2() {
    hamBurgerIndex2 = new SparkMax(RobotMap.HAM_BURGER_NEO_LEFT, SparkLowLevel.MotorType.kBrushless);
    hamBurgerIndex2.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.signals.primaryEncoderPositionPeriodMs(5); //i'm not sure if we need this
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
  }
  public void turnmotor(double voltage){
    hamBurgerIndex2.setVoltage(voltage);

  }
}