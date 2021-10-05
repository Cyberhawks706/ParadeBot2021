package org.usfirst.frc706.IR2020.parts;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;

import org.usfirst.frc706.IR2020.misc.PIDCoeffs;
import org.usfirst.frc706.IR2020.Constants;
import org.usfirst.frc706.IR2020.Part;

//DEMO OF HOW TO USE THE "PART" SYSTEM

/**
 * Generic part implementation of the Spark MAX motor controller.
 */
public class GenericSpark extends Part<CANSparkMax> {
    
    /**
     * The Spark MAX's internal PID controller.
     */
    private CANPIDController PIDcontroller;

    /**
     * Initializes a GenericSpark using a CANSparkMax controller and PID Coefficients.
     * @param controller A CANSparkMax controller.
     * @param PIDC PID coefficients.
     */
    public GenericSpark(CANSparkMax controller, PIDCoeffs PIDC) {
        super(controller);
        PIDcontroller = this.Component.getPIDController();

        PIDcontroller.setP(PIDC.P);
        PIDcontroller.setI(PIDC.I);
        PIDcontroller.setD(PIDC.D);
        PIDcontroller.setIZone(PIDC.Iz);
        PIDcontroller.setFF(PIDC.FF);
        PIDcontroller.setOutputRange(PIDC.MinOut, PIDC.MaxOut);

    }

    /**
     * Gets the current encoder position.
     * @return # of rotations.
     */
    public double getPosition() {
        return this.Component.getEncoder().getPosition();
    }

    /**
     * Manually force the encoder's position to a value. This DOES NOT move the motor to the position.
     * @param pos Position value in # of rotations.
     */
    public void setPosition(double pos) {
        this.Component.getEncoder().setPosition(pos);
    }

    /**
     * Set the power given to the motor without PID control.
     * @param percent Percentage of full power.
     */
    public void rawPower(double percent) {
        this.Component.set(percent*0.01);
    }

    /**
     * Set the power given to the motor with PID control.
     * @param percent Percentage of full power.
     */
    public void setPower(double percent) {

        double power = percent * 0.01 * Constants.Drive.PID.MaxRPM;
        PIDcontroller.setReference(power, ControlType.kVelocity);

    }

    /**
     * Sets the velocity of the motor.
     * @param velocity Velocity in RPM.
     * @return Whether the velocity was successfully set.
     */
    public boolean setVelocity(double velocity) {

        if (velocity > Constants.Drive.PID.MaxRPM || velocity < 0) return false;
        else PIDcontroller.setReference(velocity, ControlType.kSmartVelocity);

        return true;

    }

    /**
     * @param times Number of times to rotate motor. Use this to move motor to a position.
     * @return Whether motor was successfully rotated.
     */
    public boolean revolve(double times) {

        CANError e = PIDcontroller.setReference(times, ControlType.kPosition);
        return (e == CANError.kOk);

    }

    public boolean enable() {
        return true;
    }

    public boolean disable() {

        this.Component.disable();

        return true;
    }

    public void emergencyStop() {

        PIDcontroller.setReference(0, ControlType.kCurrent);
        PIDcontroller.setReference(0, ControlType.kVoltage);
        this.Component.disable();

    }

}