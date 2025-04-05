// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.coral;

import com.revrobotics.spark.ClosedLoopSlot;
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
    //config.encoder.positionConversionFactor(1).positionConversionFactor(1); //gear ratio
    config.signals.primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(0.075,0,0); //values are p, i, d, have to be tuned

    coralDumper.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

    //coralDumper.getEncoder().setPosition(0);
  }

      public void setVoltage(double voltage) {
        coralDumper.setVoltage(voltage);
      }

      public double getPosition() {
        return coralDumper.getEncoder().getPosition();
      }

      public void setCollectPosition(){
      config.closedLoopRampRate(1.0); //Take 0.8 seconds to go from 0 to full power, smoothing out
      coralDumper.getClosedLoopController().setReference(2.04, SparkMax.ControlType.kPosition); //In rotations (thank u rowan for figuring it out)
      }

      public void setDrivePosition(){
      config.closedLoopRampRate(0.2);
      coralDumper.getClosedLoopController().setReference(0.54, SparkMax.ControlType.kPosition);
      }

}
