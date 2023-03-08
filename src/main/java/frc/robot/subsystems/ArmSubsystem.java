// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenixpro.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax.SoftLimitDirection;


public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
 
 private final CANSparkMax Arm_Motor_1;
 private final CANSparkMax Arm_Motor_2;
 private final RelativeEncoder Arm_Encoder_1;
 
 

  public ArmSubsystem() {


  Arm_Motor_1 = new CANSparkMax(Constants.Spark_Arm_1_ID,MotorType.kBrushless);
  Arm_Motor_2 = new CANSparkMax(Constants.Spark_Arm_2_ID,MotorType.kBrushless);

  Arm_Motor_1.enableSoftLimit(SoftLimitDirection.kForward, true);
  Arm_Motor_1.enableSoftLimit(SoftLimitDirection.kReverse, true);

  

  Arm_Motor_1.setSoftLimit(SoftLimitDirection.kReverse, -2);
  Arm_Motor_1.setSoftLimit(SoftLimitDirection.kForward, 0);

  Arm_Encoder_1 = Arm_Motor_1.getEncoder(); 
  Arm_Encoder_1.setPositionConversionFactor(2048); 
  Arm_Motor_1.setSoftLimit(SoftLimitDirection.kReverse, -2048);
  Arm_Motor_1.setSoftLimit(SoftLimitDirection.kForward, 0);
  Arm_Encoder_1.setPosition(0);
  };



  

  @Override
  public void periodic() {
SmartDashboard.putNumber("Encoder Arm Value", getAbsoluteEncoderCounts());
    // This method will be called once per scheduler run
  }


  public void arm_up() {

   Arm_Motor_1.set(Constants.Arm_Speed_Max);
    Arm_Motor_2.set(Constants.Arm_Speed_Max);
    
    
     }

public void Arm_Speed(double speed){
  Arm_Motor_1.set(speed*Constants.Arm_Speed_Max);
  Arm_Motor_2.set(speed*Constants.Arm_Speed_Max);
}

public double getAbsoluteEncoderCounts() {
    return Arm_Encoder_1.getPosition();
}

public void resetEncoder(){
  Arm_Encoder_1.setPosition(0);
}

}
