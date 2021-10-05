package org.usfirst.frc706.IR2020.subsystems;

import com.ctre.phoenix.CANifier.PWMChannel;

import org.usfirst.frc706.IR2020.Components;
import org.usfirst.frc706.IR2020.commands.*;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc706.IR2020.LEDStuff.*;

/**
 * Daemon that handles scheduling and control over LEDPatterns. Used together with the LEDStrip class.
 */
public final class LEDdaemon extends Subsystem {

	private LEDStrip leftStrip = new LEDStrip(5, 6, 7, 500, new RGBValue(0, 0, 0));
	private LEDStrip rightStrip = new LEDStrip(8, 9, 10, 500, new RGBValue(0, 0, 0));
	
	/**
	 * The current LED pattern to be run.
	 */
	public LEDPattern currentPattern;

	public void initDefaultCommand() {
	}

	public void periodic() {

		if (currentPattern == null) return;
		
		currentPattern.run();

	}

}
