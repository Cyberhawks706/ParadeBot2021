package org.usfirst.frc706.IR2020;

/**
 * Abstract class for defining parts. Extend your part classes from this.
 */
public abstract class Part<T> {

    /**
     * Contains the component that the part relies on.
     */
    protected T Component;

    public Part(T comp) { this.Component = comp; }

    /**
     * Enables this part - use for initilization.
     * @return true/false whether part was successfully enabled.
     */
    public abstract boolean enable();

    /**
     * Disables this part - use for initilization.
     * @return true/false whether part was successfully disabled.
     */
    public abstract boolean disable();

    /**
     * Disables this part IMMEDIATELY and COMPLETELY.
     * @return true/false whether part was successfully enabled.
     */
    public abstract void emergencyStop();

    public T getComponent() { return this.Component; }

}