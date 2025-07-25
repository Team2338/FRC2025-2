// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.algae.shooter;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkLowLevel;

public class AlgaeShooterRight extends SubsystemBase {

  public static SparkMax algaeShooterRight;
  public static SparkMaxConfig config;

  public AlgaeShooterRight() {
    algaeShooterRight = new SparkMax(RobotMap.ALGAE_SHOOTER_NEO_RIGHT, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    config.closedLoop.feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder); //unsure if needed
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
    config.closedLoop
            .pid(1.00,0.0,0, ClosedLoopSlot.kSlot0)
            .iMaxAccum(0.1, ClosedLoopSlot.kSlot0);
    algaeShooterRight.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
  }

  public void setVoltage(double voltage){
    algaeShooterRight.setVoltage(voltage);
  }

  public void setCloseShootRPM(){
    algaeShooterRight.getClosedLoopController().setReference(Constants.CLOSE_SHOOT_RPM, SparkMax.ControlType.kVelocity, ClosedLoopSlot.kSlot0);
  }

  public void setFarShootRPM(){
    algaeShooterRight.getClosedLoopController().setReference(Constants.FAR_SHOOT_RPM, SparkMax.ControlType.kVelocity, ClosedLoopSlot.kSlot0);
  }

  public void setProcessorShootRPM(){
    algaeShooterRight.getClosedLoopController().setReference(Constants.PROCESSOR_SHOOT_RPM, SparkMax.ControlType.kVelocity, ClosedLoopSlot.kSlot0);
  }

  public boolean rightFulfillsRPM(double targetVelocity){
    return getRPM() >= targetVelocity;
  }

  public double getRPM(){
    return algaeShooterRight.getEncoder().getVelocity();
  }

}
