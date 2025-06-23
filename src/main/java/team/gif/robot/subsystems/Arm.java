// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

//TODO: Move some stuff over to constants

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
    config.encoder
            .countsPerRevolution(8192)
            .inverted(true);
    config.signals
            .primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(2.5,0.0,0.0)
            .iMaxAccum(0.1)
            .outputRange(-2, 2);
    armMotor.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    //armEncoder.setPosition(0);
  }

  public void setVoltage(double voltage) {
    armMotor.setVoltage(voltage);
  }

  public double getPosition() {
    return armEncoder.getPosition();
  }

  //In rotations
  public void collectPosition() {
    closedLoopController.setReference(1.10, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void farShootPosition(){
    closedLoopController.setReference(0.195, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void closeShootPosition(){
    closedLoopController.setReference(0.12, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void processorShootPosition(){
    closedLoopController.setReference(0.835, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void drivePosition() {
    closedLoopController.setReference(0.114, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void zeroPosition(){
    closedLoopController.setReference(0, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void zeroEncoder() {
    armEncoder.setPosition(0);
  }

}