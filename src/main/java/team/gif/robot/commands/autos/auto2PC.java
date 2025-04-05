package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import java.util.Timer;

import static team.gif.robot.Robot.coralDumper;

public class auto2PC extends Command {
    public int time;
    public int timer;
    public auto2PC() {
        super();
        addRequirements(Robot.coralDumper,Robot.driveTrain); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {time = 0;
        timer = 0;
        Robot.arm.drivePosition();
        System.out.println("Auto started");

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if(time <= 100){
            time += 1;
            Robot.driveTrain.driveArcade(0,-.5);
        }
        if(time > 100){
            Robot.driveTrain.driveArcade(0,0);
            timer+=1;
            if(timer<60){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT);}
            if(timer>=60){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT);}
        }
        if(timer==111){
            Robot.coralDumper.setVoltage(0);
            double gain= .04;
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
        if(timer==161){
            Robot.driveTrain.driveArcade(0,0);
            double gain= .04;
            double error=180-Robot.pigeon.get180Heading();
            double rotation= gain * error;
            Robot.driveTrain.driveArcade(-rotation,0);
            if(Robot.pigeon.get360Heading() > (359.5) || Robot.pigeon.get360Heading() < (0.5)){
                timer+=1;
                Robot.driveTrain.driveArcade(0,0);
            }
            }
        if(timer>=162&&timer<287+100){
            timer+=1;
            Robot.driveTrain.driveArcade(0,-.5);
        }
        if(timer==287+100){
            Robot.driveTrain.driveArcade(0,0);
            double gain= .04;
            double error=180-Robot.pigeon.get180Heading();
            double rotation= gain * error;
            Robot.driveTrain.driveArcade(rotation,0);
            if(Robot.pigeon.get360Heading() > (54.5) && Robot.pigeon.get360Heading() < (55.5)){
                timer+=1;
                Robot.driveTrain.driveArcade(0,0);
                coralDumper.setCollectPosition();
            }
        }
        if(timer>287+100&&timer<337+100){
            timer+=1;
            if(timer==337+100){
                coralDumper.setDrivePosition();
                timer+=1;
            }
        }
        if(timer>337+125&&timer<487+50){
            timer+=1;
            Robot.driveTrain.driveArcade(0,.5);
        }
        if(timer==487+50){
            Robot.driveTrain.driveArcade(0,0);
            double gain= .04;
            double error=180-Robot.pigeon.get180Heading();
            double rotation= gain * error;
            Robot.driveTrain.driveArcade(-rotation,0);
            if(Robot.pigeon.get360Heading() > (179.5) && Robot.pigeon.get360Heading() < (180.5)){
                timer+=1;
                Robot.driveTrain.driveArcade(0,0);
        }
    }
        if(timer>487+50&&timer<487+100){
            timer+=1;
            Robot.driveTrain.driveArcade(0,-.5);
        }
        if(timer>+487+100){
            Robot.driveTrain.driveArcade(0,0);
            timer+=1;
            if(timer<587+60){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT);}
            if(timer>=587+60){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT);}
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        if(timer==587+111){return true;}
    else {return false;}}
    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
            Robot.coralDumper.setVoltage(0);
            System.out.println("Auto ended");}}


