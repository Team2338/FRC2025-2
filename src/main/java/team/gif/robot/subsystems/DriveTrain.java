// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  private WPI_TalonSRX leftFrontNEO;
  private WPI_TalonSRX leftBackNEO;
  private WPI_TalonSRX rightFrontNEO;
  private WPI_TalonSRX rightBackNEO;

  private DifferentialDrive drive;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    leftFrontNEO = new WPI_TalonSRX(RobotMap.LEFT_FRONT_NEO);
    leftBackNEO = new WPI_TalonSRX(RobotMap.LEFT_BACK_NEO);
    rightFrontNEO = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_NEO);
    rightBackNEO = new WPI_TalonSRX(RobotMap.RIGHT_BACK_NEO);

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
