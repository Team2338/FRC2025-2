// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.Algae.shooter;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkLowLevel;

public class AlgaeShooterLeft extends SubsystemBase {
  public static SparkFlex algaeShooterLeft;
  public static SparkFlexConfig config;

  public AlgaeShooterLeft() {
    algaeShooterLeft = new SparkFlex(RobotMap.ALGAE_SHOOTER_NEO_LEFT, SparkLowLevel.MotorType.kBrushless);
    config = new SparkFlexConfig();
    config.idleMode(SparkFlexConfig.IdleMode.kBrake);
    config.closedLoop.feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder); //unsure if needed
    config.closedLoop
            .pid(1.00,0.0,0, ClosedLoopSlot.kSlot0)
            .iMaxAccum(0.1, ClosedLoopSlot.kSlot0);
    algaeShooterLeft.configure(config, SparkFlex.ResetMode.kResetSafeParameters, SparkFlex.PersistMode.kPersistParameters);
  }
  public void setVoltage(double voltage){
    algaeShooterLeft.setVoltage(voltage);
  }

  public void setCloseShootRPM(){
    algaeShooterLeft.getClosedLoopController().setReference(-Constants.CLOSE_SHOOT_RPM, SparkFlex.ControlType.kVelocity, ClosedLoopSlot.kSlot0);
  }

  public void setFarShootRPM(){
    algaeShooterLeft.getClosedLoopController().setReference(-Constants.FAR_SHOOT_RPM, SparkFlex.ControlType.kVelocity, ClosedLoopSlot.kSlot0);
  }

  public void setProcessorShootRPM(){
    algaeShooterLeft.getClosedLoopController().setReference(-Constants.PROCESSOR_SHOOT_RPM, SparkFlex.ControlType.kVelocity, ClosedLoopSlot.kSlot0);
  }

  public double getRPM(){
    return -algaeShooterLeft.getEncoder().getVelocity();
  }

}


