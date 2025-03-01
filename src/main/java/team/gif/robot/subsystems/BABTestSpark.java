// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class BABTestSpark extends SubsystemBase {
  public static SparkMax neoMotor;
  public static SparkMaxConfig sparkMaxConfig;

  public BABTestSpark() {
    neoMotor = new SparkMax(RobotMap.TEST_SPARKMAX_ID, SparkLowLevel.MotorType.kBrushless);
    sparkMaxConfig = new SparkMaxConfig();
    sparkMaxConfig.idleMode(SparkMaxConfig.IdleMode.kBrake);
    sparkMaxConfig.encoder.positionConversionFactor(1); //gear ratio
    sparkMaxConfig.signals.primaryEncoderPositionAlwaysOn(true);
    sparkMaxConfig.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kPrimaryEncoder)
            .pid(0.275,0.005,0); //values are p, i, d, have to be tuned
    neoMotor.configure(sparkMaxConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);

  }
  public void turnMotor(double voltage){
    neoMotor.setVoltage(voltage);
  }

  public void setPosition(){
    neoMotor.getClosedLoopController().setReference(2, SparkBase.ControlType.kPosition); //I dont think this is in degrees, find out how to convert it
  }

  public void zeroEncoder(){
    neoMotor.getEncoder().setPosition(0);
  }

  public void resetEncoder(){
    neoMotor.getClosedLoopController().setReference(0, SparkBase.ControlType.kPosition);
  }

  public double getPosition(){
    return neoMotor.getEncoder().getPosition();
  }


}
