// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends SubsystemBase {



 
 private final WPI_TalonSRX FR;
 private final WPI_TalonSRX FL;
 private final WPI_TalonSRX RR;
 private final WPI_TalonSRX RL;
 private final MotorControllerGroup Left;
 private final MotorControllerGroup Right;
 private final DifferentialDrive drive;
  /** Creates a new DriveTrain. */
  public DriveTrain() {

  


FR = new WPI_TalonSRX(Constants.FR_Drive_ID);
FL = new WPI_TalonSRX(Constants.FL_Drive_ID);
RR = new WPI_TalonSRX(Constants.RR_Drive_ID);
RL = new WPI_TalonSRX(Constants.RL_Drive_ID);
Left = new MotorControllerGroup(FL, RL);
Right = new MotorControllerGroup(FR, RR);
drive = new DifferentialDrive(Left,Right );
   
drive.setSafetyEnabled(false);



  }

  public void drive(double left, double right) {
    drive.tankDrive(left, right);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
