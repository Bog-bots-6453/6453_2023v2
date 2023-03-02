// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

public final static int FL_Drive_ID = 30;
public final static int FR_Drive_ID = 31;
public final static int RL_Drive_ID = 32;
public final static int RR_Drive_ID = 33;
public final static double Drive_Speed_Max = 1.0;

public final static int Intake_Right_ID = 40;
public final static int Intake_Left_ID = 41;
public final static double Intake_speed_In = 1.0; 
public final static double Intake_speed_out = -1.0;

public final static int Spark_Arm_1_ID = 50;
public final static int Spark_Arm_2_ID = 51;
public final static double Arm_Speed_Max = .8;

public final static int PCM_ID = 1;

public final static int Pivot_Open = 0; 
public final static int Pivot_Close = 1; 

public final static int Vertical_up = 2; 
public final static int Vertical_down = 3; 

public final static int Clawn_Open = 4; 
public final static int Clawn_Close = 5; 

public final static int armtoob_up = 6; 
public final static int armtoob_down = 7; 
}
