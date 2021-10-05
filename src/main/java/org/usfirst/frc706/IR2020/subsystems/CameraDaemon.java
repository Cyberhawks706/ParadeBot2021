package org.usfirst.frc706.IR2020.subsystems;

import edu.wpi.cscore.*;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Daemon that manages the initialization and control of the robot's cameras.
 */
public final class CameraDaemon extends Subsystem {

    CameraServer server = CameraServer.getInstance();

    {
    //Initialize cameras here
    }

	public void initDefaultCommand() {
	}

	public void periodic() {
        //Add stuff for manipulating cameras here
	}

}
