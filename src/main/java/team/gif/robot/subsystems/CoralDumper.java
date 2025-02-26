// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
/**
package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class CoralDumper extends SubsystemBase {
  public static SparkMax coralDumper;
  public static SparkMaxConfig config;

  public CoralDumper() {
    coralDumper = new SparkMax(RobotMap.CORAL_DUMPER_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    coralDumper.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.idleMode(SparkBaseConfig.IdleMode.kBrake);
  }

      public void turnmotor(double voltage) {
        coralDumper.setVoltage(voltage);
        System.out.println(config.encoder.positionConversionFactor(4096)); //not sure about this
      }

      public double getPosition() {
        return coralDumper.getEncoder().getPosition();
      }

      public void zeroEncoder() {
        coralDumper.getEncoder().setPosition(0); //not sure about this either
      }
    }
 */