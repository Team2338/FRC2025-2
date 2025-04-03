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

//TODO: Make code consistent with Arm code, make a couple things constants

public class CoralDumper extends SubsystemBase {
  public static SparkMax coralDumper;
  public static SparkMaxConfig config;

  public CoralDumper() {
    coralDumper = new SparkMax(RobotMap.CORAL_DUMPER_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
    config.encoder.positionConversionFactor(1).positionConversionFactor(1); //gear ratio
    config.signals.primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(0.075,0,0) //values are p, i, d, have to be tuned
            .pid( 0.1, 0, 0, ClosedLoopSlot.kSlot1)
            .velocityFF(1.0/5767, ClosedLoopSlot.kSlot1);

    coralDumper.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

    //coralDumper.getEncoder().setPosition(0);
  }

      public void setVoltage(double voltage) {
        coralDumper.setVoltage(voltage);
      }

      public double getPosition() {
        return coralDumper.getEncoder().getPosition();
      }

      public double getVelocity() {
        return coralDumper.getEncoder().getVelocity()
                ;
    }
      public void setCollectPosition(){
      coralDumper.getClosedLoopController().setReference(2.00, SparkMax.ControlType.kPosition); //In rotations (thank u rowan for figuring it out)
      }

      public void setDrivePosition(){
      coralDumper.getClosedLoopController().setReference(0, SparkBase.ControlType.kPosition);
      }

      public void setVelocityForward(){
      coralDumper.getClosedLoopController().setReference(0.5, SparkBase.ControlType.kVelocity, ClosedLoopSlot.kSlot1);
      }

      public void setVelocityBackward(){
      coralDumper.getClosedLoopController().setReference(0.2, SparkBase.ControlType.kVelocity, ClosedLoopSlot.kSlot1);
    }
}
