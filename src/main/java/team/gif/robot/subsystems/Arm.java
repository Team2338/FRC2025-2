// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

//TODO: Fix velocity control, use armfeedforward

public class Arm extends SubsystemBase {
  public static SparkMax armMotor;
  public static SparkMaxConfig config;
  public static RelativeEncoder armEncoder;
  public static SparkClosedLoopController closedLoopController;

  public Arm() {
    armMotor = new SparkMax(RobotMap.ARM_ID, SparkLowLevel.MotorType.kBrushed);
    config = new SparkMaxConfig();
    closedLoopController = armMotor.getClosedLoopController();
    armEncoder = armMotor.getEncoder();
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);

    armEncoder.setPosition(0);

    config.encoder
            .countsPerRevolution(8192)
            .inverted(true);
    config.signals
            .primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(2.25,0.0,0.0)
            .iMaxAccum(0.1)
            .outputRange(-2, 2)
            /**
             * PID for velocity control, in closedloop slot 1
             */
            .pid(0.1,0.0,0.0, ClosedLoopSlot.kSlot1)
            //12v is max applied voltage, 5310 rpm is the free speed of a cim motor
            .velocityFF(12.0 / 5310, ClosedLoopSlot.kSlot1)
            .outputRange(-1, 1, ClosedLoopSlot.kSlot1);
    armMotor.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
  }

  public void setVoltage(double voltage) {
    armMotor.setVoltage(voltage);
  }

  public double getPosition() {
    return armEncoder.getPosition();
  }

  //In rotations
  public void collectPosition() {
    closedLoopController.setReference(-.10, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void drivePosition() {
    closedLoopController.setReference(0, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void zeroEncoder() {
    armEncoder.setPosition(0);
  }

  public void setTargetRPM(double targetRPM) {
    closedLoopController.setReference(targetRPM, SparkMax.ControlType.kVelocity, ClosedLoopSlot.kSlot1);
  }

  public double getRPM() {
    return armEncoder.getVelocity();
  }

}
