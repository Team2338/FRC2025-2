package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutosGroup extends SequentialCommandGroup {
    public AutosGroup () {
        addCommands(
                new DriveForwardAuto(),
                new Drivebackauto(),
                new turnRight90auto(),
                new DriveForwardAuto2(),
                new turnlefto0auto(),
                new DriveForwardAuto3(),
                new turnrighto45auto(),
                new DriveForwardAuto(),
                new DriveBackwardAuto(),
                new turnrighto225auto(),
                new DriveForwardAuto5()
                );
        System.out.println("auto finished ");
    }
}
