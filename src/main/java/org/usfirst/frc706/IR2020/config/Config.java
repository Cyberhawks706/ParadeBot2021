package org.usfirst.frc706.IR2020.config;

public final class Config {

   public static ConfigurableBool testBool = new ConfigurableBool("TEST", true);

   public static ConfigurableNumber shooterPower = new ConfigurableNumber("SHOOTPOWER", 0);

   public static ConfigurableNumber chutePower = new ConfigurableNumber("CHUTEPOWER", 0.3);

   public static ConfigurableNumber controlWheelPower = new ConfigurableNumber("CONTROLWHEELPOWER", .1);

   public static ConfigurableNumber controlRotatorPower = new ConfigurableNumber("CONTROLROTATORPOWER", .1);

   public static ConfigurableNumber intakeRotatorPower = new ConfigurableNumber("INTAKEROTATORPOWER", .15);

   public static ConfigurableNumber intakeRollerPower = new ConfigurableNumber("INTAKEROLLERPOWER", .3);

   public static ConfigurableNumber controllerEncoder = new ConfigurableNumber("CONTROLLER_ENCODER", 0);

   public static ConfigurableBool driveInBrakeMode = new ConfigurableBool("BrakeMode", false);

   public static ConfigurableNumber LIDAR = new ConfigurableNumber("LIDAR", 0);
}