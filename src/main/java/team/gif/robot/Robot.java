// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import team.gif.robot.commands.algae.manual.ArmJoystickManual;
import team.gif.robot.commands.autos.AutosGroup;
import team.gif.robot.commands.coral.manual.CouchJoystickManual;
import team.gif.robot.commands.drivetrain.ArcadeDrive;
import team.gif.robot.subsystems.DriveTrain;
import team.gif.robot.subsystems.algae.arm.AlgaeLimitSwitch;
import team.gif.robot.subsystems.algae.arm.Arm;
import team.gif.robot.subsystems.algae.index.AlgaeShooterIndexer;
import team.gif.robot.subsystems.algae.index.AlgaeShooterIndexer2;
import team.gif.robot.subsystems.algae.shooter.AlgaeShooterLeft;
import team.gif.robot.subsystems.algae.shooter.AlgaeShooterRight;
import team.gif.robot.subsystems.coral.CoralDumper;
import team.gif.robot.subsystems.drivers.Pigeon;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private final RobotContainer robotContainer;
  public static DriveTrain driveTrain;
  public static CoralDumper coralDumper;
  public static Arm arm;
  public static Pigeon pigeon;
  public static AlgaeShooterLeft algaeShooterLeft;
  public static AlgaeShooterRight algaeShooterRight;
  public static AlgaeShooterIndexer algaeShooterIndexer;
  public static AlgaeShooterIndexer2 algaeShooterIndexer2;
  public static AlgaeLimitSwitch algaeLimitSwitch;
  public static UI ui;
  public static UiSmartDashboard uiSmartDashboard;
  public static OI oi;
  public static double matchTime;
  public static boolean endGameRumble;

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
    algaeShooterLeft = new AlgaeShooterLeft();
    algaeShooterRight = new AlgaeShooterRight();
    pigeon = new Pigeon(RobotMap.PIGEON_ID);
    arm = new Arm();
    arm.setDefaultCommand(new ArmJoystickManual());
    algaeShooterIndexer = new AlgaeShooterIndexer();
    algaeShooterIndexer2 = new AlgaeShooterIndexer2();
    algaeLimitSwitch = new AlgaeLimitSwitch();
    //autonomousCommand = new DriveForwardAuto();
    //autonomousCommand = new auto2PC();
    autonomousCommand = new AutosGroup();
    ui = new UI();
    uiSmartDashboard = new UiSmartDashboard();
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
    matchTime = DriverStation.getMatchTime(); //might need to move to teleop init
    uiSmartDashboard.updateUI();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    // schedule the autonomous command (example)
    //autonomousCommand.schedule();
    //autonomousCommand = robotContainer.getAutonomousCommand();
    //arm.setArmPosition(Constants.ARM_CLOSE_SHOOT_POSITION);
    //new AutosGroup().schedule();
    pigeon.resetPigeonPosition(0);
    autonomousCommand = new WaitCommand(uiSmartDashboard.delayChooser.getSelected()).andThen(uiSmartDashboard.autoChooser.getSelected());
    if(autonomousCommand != null){
      System.out.println("auto init: " + autonomousCommand.getName());
      autonomousCommand.schedule();
    } else {
      System.out.println("No Auto Selected");
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

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
    endGameRumble = matchTime <= 6 && matchTime >= 4;

    if(endGameRumble){
      System.out.println("activating rumble");
      oi.driver.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 1.0);
      oi.aux.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 1.0);
    } else{
      oi.driver.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0);
      oi.aux.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0);
    }


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
