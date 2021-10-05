package org.usfirst.frc706.IR2020.parts;

import edu.wpi.first.wpilibj.Solenoid;

public class SingleActionValve {
    private final Solenoid solenoid;

    public SingleActionValve(int port){
        solenoid = new Solenoid(port);
    }

    public SingleActionValve(int pcmCanId, int port){
        solenoid = new Solenoid(pcmCanId, port);
    }

    public void Open(){
        solenoid.set(true);
    }

    public void Close(){
        solenoid.set(false);
    }
}