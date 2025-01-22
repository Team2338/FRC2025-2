// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  private WPI_TalonSRX leftFrontTalon;
  private WPI_TalonSRX leftBackTalon;
  private WPI_TalonSRX rightFrontTalon;
  private WPI_TalonSRX rightBackTalon;

  private DifferentialDrive drive;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    leftFrontTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_TALON);
    leftBackTalon = new WPI_TalonSRX(RobotMap.LEFT_BACK_TALON);
    rightFrontTalon= new WPI_TalonSRX(RobotMap.RIGHT_FRONT_TALON);
    rightBackTalon = new WPI_TalonSRX(RobotMap.RIGHT_BACK_TALON);

    leftFrontTalon.configFactoryDefault();
    leftBackTalon.configFactoryDefault();
    rightFrontTalon.configFactoryDefault();
    rightBackTalon.configFactoryDefault();

    leftFrontTalon.setNeutralMode(NeutralMode.Brake);
    leftBackTalon.setNeutralMode(NeutralMode.Brake);
    rightFrontTalon.setNeutralMode(NeutralMode.Brake);
    rightBackTalon.setNeutralMode(NeutralMode.Brake);

    leftBackTalon.follow(leftFrontTalon);
    rightBackTalon.follow(rightFrontTalon);

    drive = new DifferentialDrive(leftFrontTalon, rightFrontTalon);
  }
  public void driveTank(double leftSpeed, double rightSpeed){drive.tankDrive(leftSpeed, rightSpeed);}
  public void driveArcade(double speed, double rotation){drive.arcadeDrive(speed, rotation);}
}
