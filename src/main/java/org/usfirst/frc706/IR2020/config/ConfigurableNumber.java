package org.usfirst.frc706.IR2020.config;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public final class ConfigurableNumber extends Configurable<Double> {

    public ConfigurableNumber(String name, double defaultValue) {
        super(name, defaultValue);
    }

    public boolean pull() {
       this.value = SmartDashboard.getNumber(this.name, 0.0);
       this.detectChange();
       return (this.value != 0.0);
    }

    public boolean push() {
        boolean retVal = SmartDashboard.putNumber(this.name, this.value);
        this.onChangeCallback.run();
        return retVal;
    }

}