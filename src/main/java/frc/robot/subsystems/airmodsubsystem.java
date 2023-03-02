// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class airmodsubsystem extends SubsystemBase {
  /** Creates a new airmodsubsystem. */

private final Compressor airCompressor;
private final DoubleSolenoid claw;
private final DoubleSolenoid pivot;
private final DoubleSolenoid vertical;
private final DoubleSolenoid armtoob;

  public airmodsubsystem() {

  airCompressor = new Compressor(Constants.PCM_ID,PneumaticsModuleType.CTREPCM);
  claw = new DoubleSolenoid(Constants.PCM_ID,PneumaticsModuleType.CTREPCM,Constants.Clawn_Open,Constants.Clawn_Close);
  pivot = new DoubleSolenoid(Constants.PCM_ID,PneumaticsModuleType.CTREPCM,Constants.Pivot_Open,Constants.Pivot_Close);
  vertical = new DoubleSolenoid(Constants.PCM_ID,PneumaticsModuleType.CTREPCM,Constants.Vertical_up,Constants.Vertical_down);
 armtoob = new DoubleSolenoid(Constants.PCM_ID,PneumaticsModuleType.CTREPCM,Constants.Vertical_up,Constants.Vertical_down);



  }
  



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
 
 
  }

public void Clawn_Close() {
claw.set(Value.kForward);
}
public void Clawn_Open() {
  claw.set(Value.kReverse);
}

public void pivot_open(){
pivot.set(Value.kForward);
}
public void pivot_close(){
  pivot.set(Value.kReverse);
}

public void vertical_up(){
  vertical.set(Value.kForward);
}
public void Vertical_down(){
  vertical.set(Value.kReverse);
}

public void armtoob_up(){
  armtoob.set(Value.kForward);
}
public void armtoob_down(){
  armtoob.set(Value.kReverse);
}






public void start() {
airCompressor.enableDigital();
}
}

