package org.usfirst.frc706.IR2020.subsystems;

import org.usfirst.frc706.IR2020.Components;
import org.usfirst.frc706.IR2020.Constants.IO;
import org.usfirst.frc706.IR2020.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public final class Chassis extends Subsystem {

	public void initDefaultCommand() {
		 setDefaultCommand(new Drive());
	}

	public int solsEnabled = 1;
	public boolean canPushButton = true;
	public boolean solsEnabled2 = false;
	public boolean canPushButton2 = true;

	public void periodic() {
		
		if(solsEnabled == 2){
			Components.solOne.Open();
			Components.solTwo.Close();
		}else if(solsEnabled == 3){
			Components.solOne.Close();
			Components.solTwo.Open();//Open();
		}
		else{
			Components.solOne.Close();
			Components.solTwo.Close();//Open();
		}

		if(solsEnabled2){
			Components.solThree.Open();
			Components.solFour.Close();
		}else{
			Components.solThree.Close();
			Components.solFour.Close();
		}
		
	}

}
