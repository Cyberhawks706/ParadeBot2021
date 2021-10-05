package org.usfirst.frc706.IR2020.LEDStuff;

/**
 * Simple example of how to make a breathing LED pattern.
 * You should base new LED patterns on this.
 */
public class Breathe extends LEDPattern {
    
    private int initval;
    private int breath;
    private int breathDir = 1;

    public Breathe(LEDStrip left, LEDStrip right, int initval) {
        super(left, right);
        this.initval = initval;
        this.breath = initval;
    }

    public void run() {

        breath += breathDir;

        if(breath <= initval || breath >= 255) {
            breathDir *= -1;
        }
		
		this.leftStrip.setRGB(breath, 0, breath * .05);
		this.rightStrip.setRGB(breath, 0, breath * .05);
		
		//System.out.println(breath);
    }

}