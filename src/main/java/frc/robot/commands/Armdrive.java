// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;



public class Armdrive extends CommandBase {
  private final ArmSubsystem m_ArmSubsystem;
  private final DoubleSupplier m_Speed_Axis;
  /** Creates a new Armdrive. */
  public Armdrive(ArmSubsystem m_ArmSubsystem , DoubleSupplier Speed_Axis) {

    this.m_Speed_Axis = Speed_Axis;
this.m_ArmSubsystem = m_ArmSubsystem;
addRequirements(m_ArmSubsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //drIve.tankdrive(dubble leftspeed,dubble rightspeed); name it Defaltdrivecammand
    
m_ArmSubsystem.Arm_Speed(m_Speed_Axis.getAsDouble()*-1);
System.out.println(m_Speed_Axis.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_ArmSubsystem.Arm_Speed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
