package team.gif.robot.commands.coral.syced;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.coralDumper;

<<<<<<<< HEAD:src/main/java/team/gif/robot/commands/CoralDumperAutoDump.java
public class CoralDumperAutoDump extends Command {
private int timer;
    public CoralDumperAutoDump() {
========
public class CoralDumperSycDump extends Command {
private int timer;
    public CoralDumperSycDump() {
>>>>>>>> RD_Autos.2:src/main/java/team/gif/robot/commands/coral/syced/CoralDumperSycDump.java
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
<<<<<<<< HEAD:src/main/java/team/gif/robot/commands/CoralDumperAutoDump.java
        if(timer<60){coralDumper.setVoltage(Constants.CORAL_NEO_PERCENT);}
        if(timer>=60){coralDumper.setVoltage(-Constants.CORAL_NEO_PERCENT);}
========
        if(timer<65){coralDumper.turnmotor(Constants.CORAL_NEO_PERCENT);}
        if(timer>=65){coralDumper.turnmotor(-Constants.CORAL_NEO_PERCENT);}
>>>>>>>> RD_Autos.2:src/main/java/team/gif/robot/commands/coral/syced/CoralDumperSycDump.java

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
