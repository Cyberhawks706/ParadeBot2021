package org.usfirst.frc706.IR2020;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
/* import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton; */

/**
 * Container class that handles the initialization of IO devices.
 */
public final class IO {
    
public static Joystick left_joy;
public static Joystick right_joy;
public static XboxController xbox;

/**
 * Initialize all IO devices.
 */
public static void init() {
    left_joy = new Joystick(Constants.IO.leftJoy);
    right_joy = new Joystick(Constants.IO.rightJoy);
}

}