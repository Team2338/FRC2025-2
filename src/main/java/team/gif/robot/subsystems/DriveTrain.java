// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.spark.SparkLowLevel;

public class DriveTrain extends SubsystemBase {
  private SparkMax leftFrontNEO;
  private SparkMax leftBackNEO;
  private SparkMax rightFrontNEO;
  private SparkMax rightBackNEO;

  private DifferentialDrive drive;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    leftFrontNEO = new SparkMax(RobotMap.LEFT_FRONT_NEO, SparkLowLevel.MotorType.kBrushless);
    leftBackNEO = new SparkMax(RobotMap.LEFT_BACK_NEO, SparkLowLevel.MotorType.kBrushless);
    rightFrontNEO = new SparkMax(RobotMap.RIGHT_FRONT_NEO, SparkLowLevel.MotorType.kBrushless);
    rightBackNEO = new SparkMax(RobotMap.RIGHT_BACK_NEO, SparkLowLevel.MotorType.kBrushless);

    leftFrontNEO.configFactoryDefault();
    leftBackNEO.configFactoryDefault();
    rightFrontNEO.configFactoryDefault();
    rightBackNEO.configFactoryDefault();

    leftFrontNEO.setNeutralMode(NeutralMode.Brake);
    leftBackNEO.setNeutralMode(NeutralMode.Brake);
    rightFrontNEO.setNeutralMode(NeutralMode.Brake);
    rightBackNEO.setNeutralMode(NeutralMode.Brake);

    leftBackNEO.follow(leftFrontNEO);
    rightBackNEO.follow(rightFrontNEO);

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
