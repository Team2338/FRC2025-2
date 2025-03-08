// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class CoralDumper extends SubsystemBase {
  public static SparkMax coralDumper;
  public static SparkMaxConfig config;

  public CoralDumper() {
    coralDumper = new SparkMax(RobotMap.CORAL_DUMPER_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
    config.encoder.positionConversionFactor(1); //gear ratio
    config.signals.primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(0.5,0,0); //values are p, i, d, have to be tuned
    coralDumper.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);


  }
      public void turnmotor(double voltage) {
        coralDumper.setVoltage(voltage);
      }

      public double getPosition() {
        return coralDumper.getEncoder().getPosition();
      }

      public void setCollectPosition(){
      coralDumper.getClosedLoopController().setReference(2, SparkMax.ControlType.kPosition); //In rotations (thank u rowan for figuring it out)
      }

      public void setDrivePosition(){
      coralDumper.getClosedLoopController().setReference(0, SparkBase.ControlType.kPosition);
      }

    }