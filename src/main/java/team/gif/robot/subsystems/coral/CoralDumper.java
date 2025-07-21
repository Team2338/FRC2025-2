// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.coral;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class
CoralDumper extends SubsystemBase {
  public static SparkMax coralDumper;
  public static SparkMaxConfig config;
  public static RelativeEncoder coralDumperEncoder;
  public static SparkClosedLoopController closedLoopController;


  public CoralDumper() {
    coralDumper = new SparkMax(RobotMap.CORAL_DUMPER_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    closedLoopController = coralDumper.getClosedLoopController();
    coralDumperEncoder = coralDumper.getEncoder();
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);
    config.signals
            .primaryEncoderPositionAlwaysOn(true);
    config.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(0.12,0,0)
            .iMaxAccum(0.1)
            .outputRange(-1,1);
    coralDumper.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    coralDumper.getEncoder().setPosition(0);
  }

      public void setVoltage(double voltage) {
        coralDumper.setVoltage(voltage);
      }

      public double getPosition() {
        return coralDumperEncoder.getPosition();
      }

      public void setCollectPosition(){
      closedLoopController.setReference(2.0, SparkMax.ControlType.kPosition); //In rotations (thank u rowan for figuring it out)
      }

      public void setDrivePosition(){
      closedLoopController.setReference(0.88, SparkMax.ControlType.kPosition);
      }

}
