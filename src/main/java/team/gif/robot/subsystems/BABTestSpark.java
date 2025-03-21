// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

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
    neoMotor = new SparkMax(RobotMap.TEST_SPARKMAX_ID, SparkLowLevel.MotorType.kBrushed);
    sparkMaxConfig = new SparkMaxConfig();
    sparkMaxConfig.idleMode(SparkMaxConfig.IdleMode.kBrake);
    sparkMaxConfig.encoder.positionConversionFactor(1);
    sparkMaxConfig.signals.primaryEncoderPositionAlwaysOn(true);
    sparkMaxConfig.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kAlternateOrExternalEncoder)
            .pid(0.3,0,0)
            .velocityFF(1.0)
            .outputRange(-1,1); //values are p, i, d, have to be tuned
    neoMotor.configure(sparkMaxConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

  }
  public void turnMotor(double voltage){
    neoMotor.setVoltage(voltage);
  }

  //in rotations
  public void setPosition(){
    neoMotor.getClosedLoopController().setReference(0.5, SparkMax.ControlType.kPosition);
  }

  public void zeroEncoder(){
    neoMotor.getEncoder().setPosition(0);
  }

  public void resetEncoder(){
    neoMotor.getClosedLoopController().setReference(0, SparkMax.ControlType.kPosition);
  }

  public double getPosition(){
    return neoMotor.getEncoder().getPosition();
  }


}
