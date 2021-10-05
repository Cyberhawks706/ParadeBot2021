package org.usfirst.frc706.IR2020.misc;

/** 
Holds PID coefficients so that they can be passed as a parameter.
*/
public class PIDCoeffs {
    
    public double P;
    public double I;
    public double D;
    public double Iz;
    public double FF;
    public double MinOut;
    public double MaxOut;

    public PIDCoeffs() {}

    public PIDCoeffs(double P, double I, double D, double Iz, 
    double FF, double MinOut, double MaxOut) {
        this.P = P;
        this.I = I;
        this.D = D;
        this.Iz = Iz;
        this.FF = FF;
        this.MinOut = MinOut;
        this.MaxOut = MaxOut;
    }

}