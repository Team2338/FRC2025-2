// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkLowLevel;

public class DriveTrain extends SubsystemBase {
  private SparkMax leftFrontNEO;
  private SparkMaxConfig configLeftFront;
  private SparkMax leftBackNEO;
  private SparkMaxConfig configLeftBack;
  private SparkMax rightFrontNEO;
  private SparkMaxConfig configRightFront;
  private SparkMax rightBackNEO;
  private SparkMaxConfig configRightBack;
  private DifferentialDrive drive;

  public DriveTrain() {
    leftFrontNEO = new SparkMax(RobotMap.LEFT_FRONT_NEO, SparkLowLevel.MotorType.kBrushless);
    leftBackNEO = new SparkMax(RobotMap.LEFT_BACK_NEO, SparkLowLevel.MotorType.kBrushless);
    rightFrontNEO = new SparkMax(RobotMap.RIGHT_FRONT_NEO, SparkLowLevel.MotorType.kBrushless);
    rightBackNEO = new SparkMax(RobotMap.RIGHT_BACK_NEO, SparkLowLevel.MotorType.kBrushless);

    configLeftFront = new SparkMaxConfig();
    configLeftBack = new SparkMaxConfig();
    configRightFront = new SparkMaxConfig();
    configRightBack = new SparkMaxConfig();

    leftFrontNEO.configure(configLeftFront, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    leftBackNEO.configure(configLeftBack, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    rightFrontNEO.configure(configRightFront, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    rightBackNEO.configure(configRightBack, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);

    configLeftFront.idleMode(SparkMaxConfig.IdleMode.kBrake);
    configLeftBack.idleMode(SparkMaxConfig.IdleMode.kBrake);
    configRightFront.idleMode(SparkMaxConfig.IdleMode.kBrake);
    configRightBack.idleMode(SparkMaxConfig.IdleMode.kBrake);

    configLeftBack.follow(leftFrontNEO);
    configRightBack.follow(rightFrontNEO);

    drive = new DifferentialDrive(leftFrontNEO, rightFrontNEO);
  }
  public void driveTank(double leftSpeed, double rightSpeed){drive.tankDrive(leftSpeed, rightSpeed);}
  public void driveArcade(double speed, double rotation){drive.arcadeDrive(speed, rotation);}
}

