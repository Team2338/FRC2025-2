package team.gif.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import team.gif.robot.commands.algae.collect.bothIN;
import team.gif.robot.commands.algae.positions.ArmCollectPosition;
import team.gif.robot.commands.algae.positions.ArmDrivePosition;
import team.gif.robot.commands.algae.positions.ArmZeroPosition;
import team.gif.robot.commands.algae.shoot.AlgaeShooterShoot;
import team.gif.robot.commands.algae.shoot.AlgaeShooterShootFarther;
import team.gif.robot.commands.algae.shoot.AlgaeShooterShootProcessor;
import team.gif.robot.commands.algae.shoot.ManualAlgaeShooterShoot;
import team.gif.robot.commands.algae.shoot.ManualAlgaeShooterShootFarther;
import team.gif.robot.commands.algae.shoot.ManualAlgaeShooterShootProcessor;
import team.gif.robot.commands.coral.manual.CoralDumperBackward;
import team.gif.robot.commands.coral.manual.CoralDumperForward;
import team.gif.robot.commands.coral.syced.CoralDumperSycCollect;
import team.gif.robot.commands.coral.syced.CoralDumperSycDump;
import team.gif.robot.commands.drivetrain.Reset0;

public class


OI {
    /*
     * Instantiate all joysticks/controllers and their buttons here
     *
     * Examples:
     * public final CommandXboxController driver = new CommandXboxController(0);
     *
     * public final Trigger dA = driver.a();
     */

    public final CommandXboxController driver = new CommandXboxController(RobotMap.DRIVER_CONTROLLER_ID);
    public final CommandXboxController aux = new CommandXboxController(RobotMap.AUX_CONTROLLER_ID);
    public final CommandXboxController test = new CommandXboxController(RobotMap.TEST_CONTROLLER_ID);

    public final Trigger dA = driver.a();
    public final Trigger dB = driver.b();
    public final Trigger dX = driver.x();
    public final Trigger dY = driver.y();
    public final Trigger dLBump = driver.leftBumper();
    public final Trigger dRBump = driver.rightBumper();
    public final Trigger dBack = driver.back();
    public final Trigger dStart = driver.start();
    public final Trigger dLStickBtn = driver.leftStick();
    public final Trigger dRStickBtn = driver.rightStick();
    public final Trigger dRTrigger = driver.rightTrigger();
    public final Trigger dLTrigger = driver.leftTrigger();
    public final Trigger dDPadUp = driver.povUp();
    public final Trigger dDPadRight = driver.povRight();
    public final Trigger dDPadDown = driver.povDown();
    public final Trigger dDPadLeft = driver.povLeft();
    public final Trigger dDPadDownLeft = driver.povDownLeft();

    public final Trigger aA = aux.a();
    public final Trigger aB = aux.b();
    public final Trigger aX = aux.x();
    public final Trigger aY = aux.y();
    public final Trigger aLBump = aux.leftBumper();
    public final Trigger aRBump = aux.rightBumper();
    public final Trigger aBack = aux.back();
    public final Trigger aStart = aux.start();
    public final Trigger aLStickBtn = aux.leftStick();
    public final Trigger aRStickBtn = aux.rightStick();
    public final Trigger aRTrigger = aux.rightTrigger();
    public final Trigger aLTrigger = aux.leftTrigger();
    public final Trigger aDPadUp = aux.povUp();
    public final Trigger aDPadRight = aux.povRight();
    public final Trigger aDPadDown = aux.povDown();
    public final Trigger aDPadLeft = aux.povLeft();
    public final Trigger aDPadDownLeft = aux.povDownLeft();

    public final Trigger tA = test.a();
    public final Trigger tB = test.b();
    public final Trigger tX = test.x();
    public final Trigger tY = test.y();
    public final Trigger tLBump = test.leftBumper();
    public final Trigger tRBump = test.rightBumper();
    public final Trigger tBack = test.back();
    public final Trigger tStart = test.start();
    public final Trigger tLStickBtn = test.leftStick();
    public final Trigger tRStickBtn = test.rightStick();
    public final Trigger tRTrigger = test.rightTrigger();
    public final Trigger tLTrigger = test.leftTrigger();
    public final Trigger tDPadUp = test.povUp();
    public final Trigger tDPadRight = test.povRight();
    public final Trigger tDPadDown = test.povDown();
    public final Trigger tDPadLeft = test.povLeft();


    public OI() {
        DriverStation.silenceJoystickConnectionWarning(true);

        /*
        *
        * Create controller actions here
        *
        * Usages:
        * dRTrigger.whileTrue(new CollectCommand());
        * dLTrigger.onTrue(new EjectCommand());
        * dA.whileTrue(new RepeatCommand(new RapidFire());
        * aStart.onTrue(new InstantCommand(Robot.elevator::zeroEncoder).ignoringDisable(true));
        *
        * onTrue (fka whenPressed)    Init->Execute repeats until IsFinished = true->End, will not start again at Init if still held down
        * whileTrue (fka whenHeld)    Init->Execute repeats until IsFinished = true or button released->End, will not start again at Init if still held down
        * whileTrue(new RepeatCommand()) (fka whileHeld)   Init->Execute repeats until IsFinished = true or button released->End, will start again at Init if still held down
        *
        * Simple Test:
        *   aX.onTrue(new PrintCommand("aX"));
        */

        /**
         * Driver Controller
         */

        // driver controls
        /**
         * Zeroes the coral dumper to whatever
         * position it's currently at.
         */
        dStart.and(dBack).onTrue(new InstantCommand(Robot.coralDumper::zeroEncoder));
        /**
         * Zeroes the pigeon to whatever
         * position it's currently at.
         */
        dLStickBtn.and(dBack).onTrue(new Reset0());
        dX.onTrue(new ArmZeroPosition());
        dLBump.whileTrue(new CoralDumperSycCollect());
        dRBump.onTrue(new CoralDumperSycDump());
        dLTrigger.whileTrue(new CoralDumperForward());
        dRTrigger.whileTrue(new CoralDumperBackward());

        // aux controls
        /**
         * Zeroes the arm to whatever
         * position it's currently at.
         */
        aStart.and(aBack).onTrue(new InstantCommand(Robot.arm::zeroEncoder));
        aA.whileTrue(new bothIN());
        /**
         * If the arm's manual mode is enabled,
         * the arm will shoot with correct voltages
         * without checking for any position/rpm
         * requirements. If it isn't, the arm will go
         * to the appropriate position and check all
         * necessary requirements before shooting.
         */
        aB.whileTrue(new ConditionalCommand(new ManualAlgaeShooterShootProcessor(), new AlgaeShooterShootProcessor(), () -> Robot.arm.isManualArmToggled()));
        aX.whileTrue(new ConditionalCommand(new ManualAlgaeShooterShoot(), new AlgaeShooterShoot(), () -> Robot.arm.isManualArmToggled()));
        aY.whileTrue(new ConditionalCommand(new ManualAlgaeShooterShootFarther(), new AlgaeShooterShootFarther(), () -> Robot.arm.isManualArmToggled()));
        aDPadUp.onTrue(new ArmDrivePosition());
        aDPadDown.onTrue(new ArmCollectPosition());
        /**
         * Aux will not be able to manually move the
         * arm unless this is toggled on.
         */
        aDPadLeft.onTrue(new InstantCommand(Robot.arm::toggleManualArmControl));
        aLBump.whileTrue(new CoralDumperSycCollect());
        aRBump.onTrue(new CoralDumperSycDump());
        //left joystick is manual arm
        //right joystick is manual couch

        /**
         * These buttons are to perform
         * system identification routines
         * using the test controller (2).
         */
        tA.whileTrue(Robot.arm.sysIdQuasistatic(SysIdRoutine.Direction.kForward));
        tB.whileTrue(Robot.arm.sysIdQuasistatic(SysIdRoutine.Direction.kReverse));
        tX.whileTrue(Robot.arm.sysIDDynamic(SysIdRoutine.Direction.kForward));
        tY.whileTrue(Robot.arm.sysIDDynamic(SysIdRoutine.Direction.kReverse));
    }
}
