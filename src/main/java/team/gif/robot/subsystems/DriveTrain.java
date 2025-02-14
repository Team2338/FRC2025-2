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
/** I have created this comment, so I can look like i am doing something important with a bunch of typing when i actually and not lets see hoe long this goes anyone can add to it would you like to start with a story?
 * Once upon a time there was a guy named John, and he liked pizza, he only ate pizza, all types of pizza.
 * He loved dominos dry thin crust flour on the bottom of the pie pizza
 * he went to dominos so much he started becoming the pizza
 * and one day he woke up, welllll kinda his consciousness came back to him and he was a pizza a whole pizza but the worst part of all is he had pineapple on him
 * he eventually became the most disgusting thing on planet earth besides tomatoes and brocolli
 *
 * */
