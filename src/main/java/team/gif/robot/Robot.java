// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import team.gif.robot.commands.autos.DriveForwardAuto;
import team.gif.robot.commands.ArmJoystickManual;
import team.gif.robot.commands.CouchJoystickManual;
import team.gif.robot.commands.drivetrain.ArcadeDrive;
import team.gif.robot.subsystems.AlgaeLimitSwitch;
import team.gif.robot.subsystems.Arm;
import team.gif.robot.subsystems.DriveTrain;
import team.gif.robot.subsystems.Algae.shooter.AlgaeShooterLeft;
import team.gif.robot.subsystems.Algae.index.AlgaeShooterIndexer;
import team.gif.robot.subsystems.Algae.index.AlgaeShooterIndexer2;
import team.gif.robot.subsystems.Algae.shooter.AlgaeShooterRight;
import team.gif.robot.subsystems.coral.CoralDumper;
import team.gif.robot.subsystems.drivers.Pigeon;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  public static Subsystem AlgaeShooterIndex2;
  private Command autonomousCommand;
  private final RobotContainer robotContainer;
  public static DriveTrain driveTrain;
  public static CoralDumper coralDumper;
  public static Arm arm;
  public static Pigeon pigeon;
  public static AlgaeShooterLeft algaeShooter;
  public static AlgaeShooterRight algaeShooterRight;
  public static AlgaeShooterIndexer algaeShooterIndexer;
  public static AlgaeShooterIndexer2 algaeShooterIndexer2;
  public static AlgaeLimitSwitch algaeLimitSwitch;
  public static UI ui;
  public static OI oi;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();
    driveTrain = new DriveTrain();
    coralDumper = new CoralDumper();
    coralDumper.setDefaultCommand(new CouchJoystickManual());
    //driveTrain.setDefaultCommand(new TankDrive());
    driveTrain.setDefaultCommand(new ArcadeDrive());
    algaeShooter = new AlgaeShooterLeft();
    algaeShooterRight = new AlgaeShooterRight();
    pigeon = new Pigeon(RobotMap.PIGEON_ID);
    arm = new Arm();
    arm.setDefaultCommand(new ArmJoystickManual());
    algaeShooterIndexer = new AlgaeShooterIndexer();
    algaeShooterIndexer2 = new AlgaeShooterIndexer2();
    autonomousCommand = new DriveForwardAuto();
    algaeLimitSwitch = new AlgaeLimitSwitch();
    ui = new UI();
    oi = new OI();

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    //System.out.println(coralDumper.getPosition());
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)

      System.out.println("auto init");
      new DriveForwardAuto().schedule();

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    double matchtime = DriverStation.getMatchTime();
    oi.setRumble(matchtime<=5);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
