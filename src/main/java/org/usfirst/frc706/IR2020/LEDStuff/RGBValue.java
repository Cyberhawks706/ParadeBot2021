package org.usfirst.frc706.IR2020.LEDStuff;

/**
 * Container class for holding RGB values.
 */
public class RGBValue {
    
    /**
     * Red value. 0-255.
     */
    public double R;

    /**
     * Green value. 0-255.
     */
    public double G;

    /**
     * Blue value. 0-255.
     */
    public double B;

    public RGBValue() {};

    public RGBValue(double R, double G, double B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

}