// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.algae.arm;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutVoltage;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

public class Arm extends SubsystemBase {
  public SparkMax armMotor;
  public SparkMaxConfig config;
  public RelativeEncoder armEncoder;
  public SparkClosedLoopController sparkPID;
  public ArmFeedforward armFeedforward;
  private boolean manualArmToggle = false;

  public Arm() {
    armMotor = new SparkMax(RobotMap.ARM_ID, SparkLowLevel.MotorType.kBrushed);
    config = new SparkMaxConfig();
    sparkPID = armMotor.getClosedLoopController();
    armEncoder = armMotor.getEncoder();
    armFeedforward = new ArmFeedforward(Constants.ARM_KS, Constants.ARM_KG, Constants.ARM_KV);
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
    config.encoder
            .positionConversionFactor(1) //2.0 * Math.PI
            .velocityConversionFactor(1) //2.0 * Math.PI / 60
            .countsPerRevolution(8192)
            .inverted(true);
    config.signals
            .primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(Constants.ARM_KP, Constants.ARM_KI,Constants.ARM_KD)
            .iMaxAccum(0.1)
            .outputRange(-12, 12);
    armMotor.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
  }

  public void toggleManualArmControl(){
    manualArmToggle = !manualArmToggle;
  }

  public boolean isManualArmToggled(){
    return manualArmToggle;
  }

  public void setVoltage(double voltage) {
    armMotor.setVoltage(voltage);
  }

  public double getPosition() {
    return armEncoder.getPosition();
  }

  public double getVoltage(){
    return armMotor.getBusVoltage() * armMotor.getAppliedOutput();
  }

  public double getVelocity(){
    return armEncoder.getVelocity();
  }

  public void setArmPosition(double setpoint){
    sparkPID.setReference(setpoint, SparkBase.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void holdArmPosition(double setpoint){
    double arbFF = armFeedforward.calculate(setpoint, 0.0);
    sparkPID.setReference(setpoint, SparkBase.ControlType.kPosition, ClosedLoopSlot.kSlot0, arbFF);
  }

  public boolean withinTolerance(double setpoint){
    return Math.abs(setpoint - getPosition()) <= Constants.ARM_POSITION_TOLERANCE;
  }

  public void zeroEncoder() {
    armEncoder.setPosition(0);
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
                              .angularVelocity(m_velocity.mut_replace(getVelocity(), RadiansPerSecond));
                    },
                    this));
  }

  public Command sysIdQuasistatic(SysIdRoutine.Direction direction){
    return getArmSysIdRoutine().quasistatic(direction);
  }

  public Command sysIDDynamic(SysIdRoutine.Direction direction){
    return getArmSysIdRoutine().dynamic(direction);
  }

}