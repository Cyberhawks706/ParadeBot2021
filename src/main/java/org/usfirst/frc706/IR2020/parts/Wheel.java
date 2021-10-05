package org.usfirst.frc706.IR2020.parts;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;

import org.usfirst.frc706.IR2020.Components;
import org.usfirst.frc706.IR2020.Constants;
import org.usfirst.frc706.IR2020.Part;

import edu.wpi.first.wpilibj.DriverStation;


public class Wheel extends Part<CANSparkMax> {
    
    private CANPIDController PIDcontroller;
    private MotorType motorType;


    public Wheel(CANSparkMax controller) {
        super(controller);
        PIDcontroller = this.Component.getPIDController();
        motorType = this.Component.getMotorType();

        PIDcontroller.setP(Constants.Drive.PID.P);
        PIDcontroller.setI(Constants.Drive.PID.I);
        PIDcontroller.setD(Constants.Drive.PID.D);
        PIDcontroller.setIZone(Constants.Drive.PID.Iz);
        PIDcontroller.setFF(Constants.Drive.PID.FF);
        PIDcontroller.setOutputRange(Constants.Drive.PID.MinOut, Constants.Drive.PID.MaxOut);
    }

    public void setPower(double percent) {

        if (this.motorType != MotorType.kBrushless) {
            DriverStation.reportWarning("Motor Type: " + this.motorType, false);
            DriverStation.reportError("Motor with id " + this.Component.getDeviceId() + " is trying to run setPower() but is brushed. Please use rawPower() instead.", false);
            return;
        }

        double power = percent * Constants.Drive.PID.MaxRPM;
        PIDcontroller.setReference(power, ControlType.kVelocity);
    }

    public double getPosition() {
        return this.Component.getEncoder().getPosition();
    }

    public void setPosition(double pos) {
        this.Component.getEncoder().setPosition(pos);
    }

    public void rawPower(double percent) {
        this.Component.set(percent);
    }

    public boolean setVelocity(double velocity) {

        if (velocity > Constants.Drive.PID.MaxRPM) return false;
        else PIDcontroller.setReference(velocity, ControlType.kSmartVelocity);

        return true;

    }

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