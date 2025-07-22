// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double CORAL_NEO_PERCENT = .9;
    public static final double ALGAE_SHOOTER_IN = 2;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_FAR = 12;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_CLOSE = 10.3;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_PROCESSOR = 5;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_INDEX = 12;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_INDEX_FAR = 12;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_INDEX_PROCESSOR = 3;
    public static final double CLOSE_SHOOT_RPM = 4600;
    public static final double FAR_SHOOT_RPM = 5300;
    public static final double PROCESSOR_SHOOT_RPM = 1200;
    public static final double ARM_MOVE_VOLTAGE = 2;
    public static final double ARM_KP = 2.0;
    public static final double ARM_KI = 0;
    public static final double ARM_KD = 0;
    public static final double ARM_KS = 1.7615;
    public static final double ARM_KG = 1.1703;
    public static final double ARM_KV = 6.1823;
    public static final double ARM_POSITION_TOLERANCE = 0.25;
    public static final double ARM_COLLECT_POSITION =  6.800; //1.100*(2*Math.PI);
    public static final double ARM_PROCESSOR_POSITION = 5.246; //0.835*(2*Math.PI);
    public static final double ARM_FAR_SHOOT_POSITION = 1.225; //0.195*(2*Math.PI);
    public static final double ARM_CLOSE_SHOOT_POSITION = 0.754; //0.120*(2*Math.PI);
    public static final double ARM_DRIVE_POSITION = 0.716; //0.114*(2*Math.PI);
    public static final double ARM_ZERO_POSITION = 0;

    }
