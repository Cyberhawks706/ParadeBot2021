package org.usfirst.frc706.IR2020.LEDStuff;

import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * Class representing an LED strip. Allows easy control over color channels.
 */
public class LEDStrip {

   private DigitalOutput R;
   private DigitalOutput G;
   private DigitalOutput B;

   /**
    * Initializes an LEDStrip.
    * @param portR Red channel digital port.
    * @param portG Green channel digital port.
    * @param portB Blue channel digital port.
    * @param frequency Frequency of PWM signal.
    * @param initColor The initial color of the LED strip.
    */
    public LEDStrip(int portR, int portG, int portB, double frequency, RGBValue initColor) {
        this.R = new DigitalOutput(portR);
        this.G = new DigitalOutput(portG);
        this.B = new DigitalOutput(portB);
        this.R.enablePWM(initColor.R);
        this.G.enablePWM(initColor.G);
        this.B.enablePWM(initColor.B);
        this.R.setPWMRate(frequency);
        this.G.setPWMRate(frequency);
        this.B.setPWMRate(frequency);
    }

    public void setRGB(double R, double G, double B) {
        this.R.updateDutyCycle(R/255);
        this.G.updateDutyCycle(G/255);
        this.B.updateDutyCycle(B/255);
    }

}