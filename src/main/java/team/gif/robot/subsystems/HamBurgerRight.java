// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class HamBurgerRight extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public static TalonSRX hamBurgerRight;
  public HamBurgerRight() {
    hamBurgerRight = new TalonSRX(RobotMap.HAM_BURGER_NEO_RIGHT);
    hamBurgerRight.configFactoryDefault();
    hamBurgerRight.setNeutralMode(NeutralMode.Brake);
  }
  public void turnmotor(double percentOutput) {hamBurgerRight.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }


}
