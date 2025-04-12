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
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_FAR = 8.4;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_CLOSE = 4.4;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_PROCESSOR = 2;
    public static final double CORAL_NEO_PERCENT = .9;
    public static final double ALGAE_SHOOTER_NEO_VOLTAGE_INDEX = 6;
    public static final double ALGAE_SHOOTER_IN = 2;
    public static final double ARM_MOVE_VOLTAGE = 2;
    public static final double CLOSE_SHOOT_RPM = 2400;
    public static final double FAR_SHOOT_RPM = 4600;
    public static final double PROCESSOR_SHOOT_RPM = 1100;
    public static final double BOOST = 2;
    public static final double ARM_KG = 2.7839; //gravity (volts)
    public static final double ARM_KS = 0.81011; //how many volts is required to overcome to motor's static friction
    public static final double ARM_KV = 7.4686; //volts * seconds / radians
    public static final double ARM_KA = 0.54454; //volts * seconds^2 / radians
    public static final double ARM_ZERO_POSITION_IN_RADIANS = 0;
    public static final double ARM_DRIVE_POSITION_IN_RADIANS = 0.474;
    public static final double ARM_CLOSE_SHOOT_POSITION_IN_RADIANS = 0.850;
    public static final double ARM_FAR_SHOOT_POSITION_IN_RADIANS = 1.412;
    public static final double ARM_PROCESSOR_SHOOT_POSITION_IN_RADIANS = 5.648;
    public static final double ARM_GROUND_COLLECT_POSITION_IN_RADIANS = 6.232;
    public static final double ARM_ERROR_TOLERANCE = 0.15;
    public static final double ARCADE_DRIVE_MAX_ACCELERATION_UNITS_PER_SECOND = 2;
    public static final double ARCADE_DRIVE_MAX_TURN_UNITS_PER_SECOND = 2;

    //TODO: Make names more accurate
}

