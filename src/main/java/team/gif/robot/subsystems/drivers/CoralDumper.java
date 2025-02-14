// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

<<<<<<<< HEAD:src/main/java/team/gif/robot/subsystems/drivers/CoralDumper.java
import static team.gif.robot.subsystems.AlgaeShooterLeft.config;

public class CoralDumper extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public static SparkMax CoralDumper;
  public CoralDumper() {
    CoralDumper = new SparkMax(RobotMap.CORAL_DUMPER_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    CoralDumper.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    config.signals.primaryEncoderPositionPeriodMs(5); //i'm not sure if we need this
========
public class Couch extends SubsystemBase {
  public static SparkMax couch;
  public static SparkMaxConfig config;
  //double position = couch.getEncoder().getPosition(); doesn't work
  //double positionFactor = couch.configAccessor.encoder.getPositionConversionFactor(); might have to use this?


  public Couch() {
    couch = new SparkMax(RobotMap.COUCH_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
    config = new SparkMaxConfig();
    couch.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
>>>>>>>> origin/ek-NeoRefactor:src/main/java/team/gif/robot/subsystems/Couch.java
    config.idleMode(SparkMaxConfig.IdleMode.kBrake);

  }
  public void turnmotor(double voltage) {
<<<<<<<< HEAD:src/main/java/team/gif/robot/subsystems/drivers/CoralDumper.java
    CoralDumper.setVoltage(voltage);
========
    couch.setVoltage(voltage);
    System.out.println(config.encoder.positionConversionFactor(4096)); //not sure about this
  }

  public double getPosition(){
    return couch.getEncoder().getPosition();
  }
  public void zeroEncoder(){
    couch.getEncoder().setPosition(0); //not sure about this either
>>>>>>>> origin/ek-NeoRefactor:src/main/java/team/gif/robot/subsystems/Couch.java
  }
}
