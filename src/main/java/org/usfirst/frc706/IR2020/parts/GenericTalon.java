package org.usfirst.frc706.IR2020.parts;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc706.IR2020.Part;

//DEMO OF HOW TO USE THE "PART" SYSTEM

/**
 * Generic part implementation of the TalonSRX motor controller.
 */
public class GenericTalon extends Part<TalonSRX> {

    /**
     * Initializes a GenericTalon from a TalonSRX controller.
     * @param controller A TalonSRX controller.
     */
    public GenericTalon(TalonSRX controller) {
        super(controller);
    }

    /**
     * Set the power given to the motor.
     * @param percent Percentage of full power.
     */
    public void rawPower(double percent) {

        this.Component.set(ControlMode.PercentOutput, percent * 0.01);

    }

    public boolean enable() {
        this.Component.set(ControlMode.Disabled, 0);
        return true;
    }

    public boolean disable() {

        this.Component.set(ControlMode.Disabled, 1);

        return true;
    }

    public void emergencyStop() {

        this.Component.set(ControlMode.Disabled, 1);

    }

}