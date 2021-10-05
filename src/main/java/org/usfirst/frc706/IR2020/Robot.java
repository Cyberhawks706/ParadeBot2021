package org.usfirst.frc706.IR2020;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

//ALL PERIODIC METHODS SHOULD CONTAIN "Scheduler.getInstance.Run()" IN ORDER FOR THE COMMAND SYSTEM TO FUNCTION CORRECTLY

	public void robotInit() {
		SmartDashboard.putBoolean("Sm_dash_working", true);
		IO.init();
		Components.init();
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {	
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

}
