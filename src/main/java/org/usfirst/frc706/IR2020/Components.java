package org.usfirst.frc706.IR2020;

import org.usfirst.frc706.IR2020.subsystems.*;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.usfirst.frc706.IR2020.config.*;
import org.usfirst.frc706.IR2020.parts.SingleActionValve;
import org.usfirst.frc706.IR2020.parts.Wheel;

/**
 * Container class that manages the initialization of subsystems and robot parts.
 */
//test change (if you see this delete this)
//test change #2
public final class Components {

    public static DashboardDaemon dashDaemon;
    public static DriverStation driverStation;
    public static NetworkTableInstance networkTableInstance;
    public static Config configTable;
    public static Wheel backRight;
    public static Wheel backLeft;
    public static Wheel frontRight;
    public static Wheel frontLeft;
    public static SingleActionValve solOne;
    public static SingleActionValve solTwo;

    public static SingleActionValve solThree;
    public static SingleActionValve solFour;

    public static Chassis chassis;

    /**
     * Initialize the robot's components
     */
    public static void init() {

     //This method should be called by the initRobot method of Robot.java
     //The purpose of this method is to initialize instances of the robot's various programmable parts for use in the other files
     //For example, this file should be where instances of motor controllers and compressors are defined

    configTable = new Config();
    driverStation = DriverStation.getInstance();
    networkTableInstance = NetworkTableInstance.getDefault();


    //Subsystems
    


    //Sparks
    backRight = new Wheel(new CANSparkMax(Constants.SparkIDs.Drive.backRight, MotorType.kBrushless));
    backLeft = new Wheel(new CANSparkMax(Constants.SparkIDs.Drive.backLeft, MotorType.kBrushless));
    frontRight = new Wheel(new CANSparkMax(Constants.SparkIDs.Drive.frontRight, MotorType.kBrushless));
    frontLeft = new Wheel(new CANSparkMax(Constants.SparkIDs.Drive.frontLeft, MotorType.kBrushless));
    solOne = new SingleActionValve(1);
    solTwo = new SingleActionValve(2);

    solThree = new SingleActionValve(4);
    solFour = new SingleActionValve(7);

    chassis = new Chassis();

    }

}
