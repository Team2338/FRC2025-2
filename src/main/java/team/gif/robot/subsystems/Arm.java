// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutVoltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;


import java.util.logging.Logger;


public class Arm extends SubsystemBase {
  //declare motor, encoder, pid control, etc
  public static SparkMax armMotor;
  public static SparkMaxConfig armMotorConfig;
  public static RelativeEncoder armEncoder;
  public static SparkClosedLoopController closedLoopController;
  public ArmFeedforward armFeedforward;

  public Arm() {
    //initialize motors
    armMotor = new SparkMax(RobotMap.ARM_ID, SparkLowLevel.MotorType.kBrushed);
    armMotorConfig = new SparkMaxConfig();

    //Arm PID controller
    closedLoopController = armMotor.getClosedLoopController();

    //Arm throughbore encoder set in relative mode
    armEncoder = armMotor.getEncoder();

    //configure motor
    armMotorConfig.idleMode(SparkMaxConfig.IdleMode.kBrake);

    //Arm feedforward
    armFeedforward = new ArmFeedforward(
            Constants.ARM_KS,
            Constants.ARM_KG,
            Constants.ARM_KV,
            Constants.ARM_KA
    );

    //configure encoder
    armMotorConfig.encoder
            .positionConversionFactor(2.0 * Math.PI) //Convert position to radians for armfeedforward
            .velocityConversionFactor(2.0 * Math.PI / 60.0) //Convert velocity to radians per second for armfeedforward
            .countsPerRevolution(8192) //throughbore encoder has a cpr of 8192
            .inverted(true);

    //enables status frames at all times
    armMotorConfig.signals
            .primaryEncoderPositionAlwaysOn(true);

    //configure pid control (defaults to closedloopslot 0)
    armMotorConfig.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(2.25,0.0,0.0)
            .iMaxAccum(0.1)
            .outputRange(-2, 2);

    //apply configurations
    armMotor.configure(armMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    //armEncoder.setPosition(0);
  }

  //multiplies the voltage fed into the sparkmax (ex: 12v) by the applied output (ex: 1)
  public double getVoltage(){
    return armMotor.getBusVoltage() * armMotor.getAppliedOutput();
  }

  public double getPosition() {
    return armEncoder.getPosition();
  }

  public double getRPM() {
    return armEncoder.getVelocity();
  }

  public void setVoltage(double voltage) {
    armMotor.setVoltage(voltage);
  }

  public void setArmPosition(double setpoint){
    double feedforward = armFeedforward.calculate(setpoint, armEncoder.getVelocity());
    closedLoopController.setReference(setpoint, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0, feedforward);
  }

  public void zeroEncoder() {
    armEncoder.setPosition(0);
  }

  public boolean atSetpoint(double setpoint){
    return Math.abs(getPosition() - setpoint) < Constants.ARM_ERROR_TOLERANCE;
  }

  private SysIdRoutine getArmSysIdRoutine() {
    MutVoltage m_appliedVoltage = Volts.mutable(0);
    MutAngle m_angle = Radians.mutable(0);
    MutAngularVelocity m_velocity = RadiansPerSecond.mutable(0);

    return new SysIdRoutine(
            new SysIdRoutine.Config(),
            new SysIdRoutine.Mechanism(
                    voltage -> {
                      armMotor.setVoltage(voltage.baseUnitMagnitude());
                    },
                    sysIdRoutineLog -> {
                      sysIdRoutineLog.motor("arm")
                              .voltage(m_appliedVoltage.mut_replace(getVoltage(), Volts))
                              .angularPosition(m_angle.mut_replace(getPosition(), Radians))
                              .angularVelocity(m_velocity.mut_replace(getRPM(), RadiansPerSecond));
                    },
           this));
  }

  public Command sysIdQuasistatic(SysIdRoutine.Direction direction){
    return getArmSysIdRoutine().quasistatic(direction);
  }

  public Command sysIdDynamic(SysIdRoutine.Direction direction){
    return getArmSysIdRoutine().dynamic(direction);
  }

  /**
  public void collectPosition() {
    closedLoopController.setReference(1.10, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0, armFeedforward.calculate(1.10, armEncoder.getVelocity()));
  }

  public void farShootPosition(){
    closedLoopController.setReference(0.25, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0, armFeedforward.calculate(0.25, armEncoder.getVelocity()));
  }

  public void closeShootPosition(){
    closedLoopController.setReference(0.15, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0, armFeedforward.calculate(0.15, armEncoder.getVelocity()));
  }

  public void processorShootPosition(){
    closedLoopController.setReference(0.80, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0, armFeedforward.calculate(0.80, armEncoder.getVelocity()));
  }

  public void drivePosition() {
    closedLoopController.setReference(0.114, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0, armFeedforward.calculate(0.114, armEncoder.getVelocity()));
  }

  public void zeroPosition(){
    closedLoopController.setReference(0, SparkBase.ControlType.kPosition, ClosedLoopSlot.kSlot0, armFeedforward.calculate(0, armEncoder.getVelocity()));
  }
  */

}