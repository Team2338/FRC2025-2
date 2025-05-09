package team.gif.robot.commands.coral.syced;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.coralDumper;

public class CoralDumperSycDump extends Command {
private int timer;
    public CoralDumperSycDump() {
        super();
        addRequirements(coralDumper);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer=0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        timer+=1;
        if(timer<60){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT);}
        if(timer>=60){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT);}

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        if(timer>120){return true;}
        else{return false;}
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.coralDumper.setVoltage(0);

    }
}
