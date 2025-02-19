// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.REVLibError;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkRelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class CoralDumper extends SubsystemBase {
    public static SparkMax coralDumper;
    public static SparkMaxConfig config;
    public static SparkRelativeEncoder relativeEncoder;

    public CoralDumper() {
        coralDumper = new SparkMax(RobotMap.CORAL_DUMPER_NEO_TEST, SparkLowLevel.MotorType.kBrushless);
        config = new SparkMaxConfig();
        coralDumper.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        config.idleMode(SparkMaxConfig.IdleMode.kBrake);
    }

    public void setVoltage(double voltage) {
        coralDumper.setVoltage(voltage);
        System.out.println(coralDumper);
    }

    public double getPosition() {
        return relativeEncoder.getPosition();
    }

    public REVLibError setPositionForward(){  //doesn't work without revliberror for some reason
        return relativeEncoder.setPosition(10); //values are placeholders
    }

    public REVLibError setPositionBackward(){
        return relativeEncoder.setPosition(50); //values are placeholders
    }

    public void zeroEncoder() {
        relativeEncoder.setPosition(0);
    }
}