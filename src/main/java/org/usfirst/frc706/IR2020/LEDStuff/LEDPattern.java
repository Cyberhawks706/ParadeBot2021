package org.usfirst.frc706.IR2020.LEDStuff;

/**
 * Represents an LED pattern. Implements runnable
 * allowing it to be run() in a seperate thread. Alternatively,
 * the run method can be called manually from something like
 * LEDdaemon.
 */
public abstract class LEDPattern implements Runnable {
    
    protected LEDStrip leftStrip;
    protected LEDStrip rightStrip;

    /***
     * Initializes a LEDPattern.
     * @param left The left LEDStrip.
     * @param right The right LEDStrip.
     */
    public LEDPattern(LEDStrip left, LEDStrip right) {
        this.leftStrip = left;
        this.rightStrip = right;
    }

    /**
     * Runs one cycle of the pattern. Write your pattern code in this.
     */
    public abstract void run();

}