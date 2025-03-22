// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.AlternateEncoderConfig;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

import java.sql.SQLOutput;

import static team.gif.robot.subsystems.BABTestTalon.cimMotor;

public class BABTestSpark extends SubsystemBase {
  public static SparkMax cimMotor;
  public static SparkMaxConfig sparkMaxConfig;
  public static DutyCycleEncoder absoluteEncoder;
  //    public static SparkClosedLoopController closedLoopController;
//  public static RelativeEncoder encoder; //Issue here
//  public static AlternateEncoderConfig encoderConfig;
  public double startPosition = 0.0;
  public boolean rotating;
  public static PIDController pidController;

  public BABTestSpark() {
    cimMotor = new SparkMax(RobotMap.TEST_SPARKMAX_ID, SparkLowLevel.MotorType.kBrushed);
//    closedLoopController = cimMotor.getClosedLoopController();
//    encoder = cimMotor.getAlternateEncoder(); //Issue here
    absoluteEncoder = new DutyCycleEncoder(0);
    pidController = new PIDController(1.0,0.0,0.0);
    pidController.enableContinuousInput(0.0, 1.0);
    pidController.setTolerance(0.01);
    rotating = false;
  }

  public double getPosition(){
    startPosition = absoluteEncoder.get();
    return startPosition;
  }

  public void setPosition(){
    double currentPosition = 0;
    double targetPosition = (startPosition + 0.5) % 1.0;

    pidController.reset();
    pidController.setSetpoint(targetPosition);
    rotating = true;

    while (!pidController.atSetpoint()) {
      currentPosition = absoluteEncoder.get();
      double output = pidController.calculate(currentPosition);
      cimMotor.set(output);
    }
    rotating = false;


  }

  public void atPosition(){
      cimMotor.set(0);
      System.out.println("Half turn complete");
      }

    /*double error = Math.abs(currentPosition-targetPosition);
    error = Math.min(error, 1.0 - error);

    if(error < 0.01){
      cimMotor.set(0);
      rotating = false;
      System.out.println("Half turn complete.");
    } else{
      cimMotor.set(0.3); */}









/**

    sparkMaxConfig = new SparkMaxConfig();

    sparkMaxConfig.idleMode(SparkMaxConfig.IdleMode.kBrake);

     * Will have to adjust the values because we aren't using the
     * integrated neo motor encoder.

  sparkMaxConfig.encoder
            .positionConversionFactor(1)
            .velocityConversionFactor(1);
    /**
     * Should be making the encoder outputs postive
     * We might not need this
     */
    //sparkMaxConfig.signals.primaryEncoderPositionAlwaysOn(true);

    /**
     * Configure the closed loop controller.
     * Feedback sensor might be causing a couple of our problems,
     * previously it was kAbsoluteEncoder, but I changed it to
     * kPrimaryEncoder.
     */
    /**
     * Default closedloop slot of 0

    sparkMaxConfig.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kAbsoluteEncoder) //Issue here
            .pid(0.3, 0.0, 0.0)
            .outputRange(-1, 1)
            /**
             * PID for velocity control, in closedloop slot 1

            .pid(0.1, 0.0, 0.0, ClosedLoopSlot.kSlot1)
             //Is the reciprocal of velocity?
            .velocityFF(1.0 / 1000, ClosedLoopSlot.kSlot1)
            .outputRange(-1, 1, ClosedLoopSlot.kSlot1);
    cimMotor.configure(sparkMaxConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

  }

  public void turnMotor(double voltage) {
    cimMotor.setVoltage(voltage);
  }

  //in rotations
  public void setPosition() {
    cimMotor.getClosedLoopController().setReference(0.5, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public void zeroEncoder() {
   cimMotor.getEncoder().setPosition(0);
  }

  public void resetEncoder() {
    cimMotor.getClosedLoopController().setReference(0, SparkMax.ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }

  public double getPosition() {
    return cimMotor.getEncoder().getPosition();
  }

  public void setVelocity() {
    cimMotor.getClosedLoopController().setReference(1, SparkBase.ControlType.kVelocity, ClosedLoopSlot.kSlot1);
  }
  public double getVelocity() {
   return cimMotor.getEncoder().getVelocity();
  }
}
*/