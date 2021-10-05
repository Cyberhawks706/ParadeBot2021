package org.usfirst.frc706.IR2020;

//ONLY PUT ***CONSTANTS*** IN HERE! THINGS THAT ARE MEANT TO BE CONFIGURABLE SHOULD BE IN config/Config.java

/**
 * Storage class for various robot constants.
 */
public final class Constants {

	public static final class SparkIDs {

		public static final class Drive {
			public final static int backRight = 1;
			public final static int backLeft = 3;
			public final static int frontRight = 2;
			public final static int frontLeft = 4;
		}

		//All spark IDs get put here or here
	}

	public final class Drive {

		public final static double sensitivity = 0.175;

		public final class PID {
			
			public final static double P = 5e-5;
			public final static double I = 1e-6;
			public final static double D = 0;
			public final static double Iz = 0;
			public final static double FF = 0;
			public final static double MaxOut = 1;
			public final static double MinOut = -1;
			public final static double MaxRPM = 5700;

		}

	}
	
	public final class IO {
		//All IO constants get put here such as controller button IDs and the like
		public final static int rightJoy = 5;
		public final static int leftJoy = 1;
	
	public final static double JoyDeadband = 0.2;
	
	}

	public final class Vision {
		//All vision constants go here
	}

	//Feel free to add more subclasses for specific subsystems

}