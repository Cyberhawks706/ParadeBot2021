package org.usfirst.frc706.IR2020.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax.IdleMode;

import org.usfirst.frc706.IR2020.Components;
import org.usfirst.frc706.IR2020.Constants;
import org.usfirst.frc706.IR2020.IO;
import org.usfirst.frc706.IR2020.config.Config;

public final class Drive extends Command {

	public Drive() {
		requires(Components.chassis);
	}

	public void initialize() {
	}

	public void execute() {	
		double leftSpeed = -IO.left_joy.getRawAxis(1);
		double rightSpeed = IO.right_joy.getRawAxis(1);
		Components.backRight.rawPower(rightSpeed);
		Components.backLeft.rawPower(leftSpeed);
		Components.frontRight.rawPower(rightSpeed);
		Components.frontLeft.rawPower(leftSpeed);

		if(IO.left_joy.getRawButton(1)){
			if(Components.chassis.canPushButton)Components.chassis.solsEnabled = 3;
			Components.chassis.canPushButton = false;
		}else if(IO.right_joy.getRawButton(1)){
			if(Components.chassis.canPushButton)Components.chassis.solsEnabled = 2;
			Components.chassis.canPushButton = false;
		}else{
			Components.chassis.solsEnabled = 1;
			Components.chassis.canPushButton = true;
		}

		if(IO.right_joy.getRawButton(1)){
			if(Components.chassis.canPushButton2)Components.chassis.solsEnabled2 = !Components.chassis.solsEnabled2;
			Components.chassis.canPushButton2 = false;
		}else{
			Components.chassis.canPushButton2 = true;
		}
	}
	
	public boolean isFinished() {
		return false; //Returning false ensures command runs forever, otherwise put an exit condition here
	}

	public void end() {
	}

	public void interrupted() {
	}
}
