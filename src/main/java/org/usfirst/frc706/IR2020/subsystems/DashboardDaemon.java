package org.usfirst.frc706.IR2020.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc706.IR2020.config.Config;

/**
 * Daemon that handles the pushing and pulling of Configurable types to / from SmartDashboard.
 */
public final class DashboardDaemon extends Subsystem {

        { //You can set callbacks here

        }

	public void initDefaultCommand() {
        //No default command, is a daemon
	}


	public void periodic() {		
        //Put any push and pull calls here to update Config values.              
	}

}