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

public class BABTestSpark extends SubsystemBase {
  public static SparkMax sparkMax;
  public static SparkMaxConfig sparkMaxConfig;

  public BABTestSpark() {
    sparkMax = new SparkMax(RobotMap.TEST_SPARKMAX_ID, SparkLowLevel.MotorType.kBrushless);
    sparkMaxConfig = new SparkMaxConfig();
    sparkMax.configure(sparkMaxConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    sparkMaxConfig.idleMode(SparkMaxConfig.IdleMode.kBrake);
  }
  public void turnMotor(double voltage){
    sparkMax.setVoltage(voltage);
  }
}
