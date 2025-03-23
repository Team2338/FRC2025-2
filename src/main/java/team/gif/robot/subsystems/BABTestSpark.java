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
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;



public class BABTestSpark extends SubsystemBase {
  public static SparkMax cimMotor;
  public static SparkMaxConfig sparkMaxConfig;
  public static SparkClosedLoopController closedLoopController;
  public static ClosedLoopConfig closedLoopConfig;
  public static RelativeEncoder encoder; //Issue here

  public BABTestSpark() {
    cimMotor = new SparkMax(RobotMap.TEST_SPARKMAX_ID, SparkLowLevel.MotorType.kBrushed);
    closedLoopController = cimMotor.getClosedLoopController();
    closedLoopConfig = new ClosedLoopConfig();
    encoder = cimMotor.getEncoder(); //Issue here

    sparkMaxConfig = new SparkMaxConfig();

    sparkMaxConfig.idleMode(SparkMaxConfig.IdleMode.kBrake);

    closedLoopConfig.feedbackSensor(ClosedLoopConfig.FeedbackSensor.kNoSensor); //issue here

    encoder.setPosition(0);

  /**
     * Will have to adjust the values because we aren't using the
     * integrated neo motor encoder.
   */

    sparkMaxConfig.encoder
            .positionConversionFactor(1)
            .velocityConversionFactor(1);
  /**
   * Should be making the encoder outputs postive
   * We might not need this
   */

    sparkMaxConfig.signals.primaryEncoderPositionAlwaysOn(true);

    /**
     * Configure the closed loop controller.
     * Feedback sensor might be causing a couple of our problems,
     * previously it was kAbsoluteEncoder, but I changed it to
     * kPrimaryEncoder.
     */

    /**
     * Default closedloop slot of 0
     */
    sparkMaxConfig.closedLoop
            .feedbackSensor(ClosedLoopConfig.FeedbackSensor.kNoSensor) //Issue here
            .pid(0.3, 0.0, 0.0)
            .outputRange(-1, 1)
            /**
             * PID for velocity control, in closedloop slot 1
             */
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
    closedLoopController.setReference(0.5, SparkMax.ControlType.kDutyCycle, ClosedLoopSlot.kSlot0);
  }

  public void zeroEncoder() {
   encoder.setPosition(0);
  }

  public void resetEncoder() {
    closedLoopController.setReference(0, SparkMax.ControlType.kDutyCycle, ClosedLoopSlot.kSlot0);
  }

  public double getPosition() {
    return encoder.getPosition();
  }

  public void setVelocity() {
    closedLoopController.setReference(1, SparkBase.ControlType.kVelocity, ClosedLoopSlot.kSlot1);
  }
  public double getVelocity() {
   return encoder.getVelocity();
  }
}
