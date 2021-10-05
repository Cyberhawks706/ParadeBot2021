package org.usfirst.frc706.IR2020.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc706.IR2020.config.Config;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;

/**
 * Subsystem for interfacing with the lidar distance sensor over the roboRIO's digital ports.
 */
public class Lidar extends Subsystem {

    DigitalInput lidarInput = new DigitalInput(3);
    DigitalOutput lidarOutput = new DigitalOutput(2);
    Timer timer = new Timer();
    Thread lidarThread;       

    {
        lidarOutput.set(true);
        
        lidarThread = new Thread(() -> {
            
            double total = 0;

            while (true) {

            for(int i = 0; i < 10; i++){
                double value = getDistance();
                if(value > 3  && value < 100){
                    total += value;
                }else{
                    i--;
                }
            }
            Config.LIDAR.value = (double)(int)((total / 10) - 2.75);
            total = 0;

        }
                
        });

        lidarThread.start();

    }


    public void initDefaultCommand() {
    }

    public void periodic() {
        //Put scheduled code here
    }

    /**
     * Gets the current distance read by the lidar.
     * @return Distance in inches.
     */
    public double getDistance() {
        timer.reset();
        lidarOutput.set(false);
        while(lidarInput.get() == false){}
        timer.start();
        while(lidarInput.get() == true){}
        lidarOutput.set(true);
        return timer.get()*10e4/2.54;
    }

}