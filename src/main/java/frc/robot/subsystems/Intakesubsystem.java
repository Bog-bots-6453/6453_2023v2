// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.motorcontrol.Victor;
//import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import edu.wpi.first.wpilibj.motorcontrol.Victor;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Intakesubsystem extends SubsystemBase {
  /** Creates a new intakesubsystem. */

private final VictorSPX Intake_Right;
private final VictorSPX Intake_Left;


  public Intakesubsystem() {


    Intake_Right = new VictorSPX(Constants.Intake_Right_ID);
    Intake_Left = new VictorSPX(Constants.Intake_Left_ID);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void Intake_In(){

Intake_Right.set(ControlMode.PercentOutput,Constants.Intake_speed_Right);
Intake_Left.set(ControlMode.PercentOutput,Constants.Intake_speed_Right*-1);

}

public void Intake_out(){
  Intake_Right.set(ControlMode.PercentOutput,Constants.Intake_speed_Left);
  Intake_Left.set(ControlMode.PercentOutput,Constants.Intake_speed_Left*-1);

}

public void Intake_stop(){
  Intake_Right.set(ControlMode.PercentOutput,Constants.Intake_speed_Right*0);
  Intake_Left.set(ControlMode.PercentOutput,Constants.Intake_speed_Left*0);


}
}