package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutosGroup extends SequentialCommandGroup {
    public AutosGroup () {
        addCommands(
                new DriveForwardAuto(),
                new turnRight90auto()
        );
    }
}
