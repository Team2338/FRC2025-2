package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.coralDumper;

public class AndOutWay1pcAuto extends Command {
    public int time;
    public int timer;
    public AndOutWay1pcAuto() {
        super();
        addRequirements(Robot.coralDumper,Robot.driveTrain); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {time = 0;
        timer = 0;
        Robot.arm.setArmPosition(Constants.ARM_FAR_SHOOT_POSITION);
        System.out.println("Auto started");

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(time <= 100){
            time += 1;
            Robot.driveTrain.driveArcade(0,-.5);
        }
        if(time == 101){
            Robot.driveTrain.driveArcade(0,0);
            timer+=1;
            if(timer<60){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT);}
            if(timer>=60){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT);}
        }
        if(timer==111){
            time+=1;
            Robot.coralDumper.setVoltage(0);
            double gain= .01;
            double error=180-Robot.pigeon.get180Heading();
            double rotation= gain * error;
            Robot.driveTrain.driveArcade(rotation,0);
            if( Robot.pigeon.get360Heading() > (90 * 0.98) && Robot.pigeon.get360Heading() < (90 * 1.02)){
                Robot.driveTrain.driveArcade(0,0);
                timer+=1;
            }
        }
        if(timer>111&&timer<161){
            timer+=1;
            Robot.driveTrain.driveArcade(0,.5);
        }
        if(timer>=161){
            Robot.driveTrain.driveArcade(0,0);
            double gain= .04;
            double error=180-Robot.pigeon.get180Heading();
            double rotation= gain * error;
            Robot.driveTrain.driveArcade(-rotation,0);
            }

    }



    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return Robot.pigeon.get360Heading() > (359.5) || Robot.pigeon.get360Heading() < (0.5);
    }
    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrain.driveArcade(0,0);
        System.out.println("Auto ended");

    }}
