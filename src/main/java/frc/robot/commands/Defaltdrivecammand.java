// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;



public class Defaltdrivecammand extends CommandBase {
  private final DriveTrain m_DriveTrain;
  private final DoubleSupplier m_LeftStick;
  private final DoubleSupplier m_RightStick;
  
  /** Creates a new Defaltdrivecammand. */
  public Defaltdrivecammand(DriveTrain m_DriveTrain,DoubleSupplier leftspeed, DoubleSupplier rightspeed) {

this.m_LeftStick = leftspeed;
this.m_RightStick = rightspeed;
this.m_DriveTrain = m_DriveTrain;
addRequirements(m_DriveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {



m_DriveTrain.drive(m_LeftStick.getAsDouble() ,m_RightStick.getAsDouble());



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {


m_DriveTrain.drive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
