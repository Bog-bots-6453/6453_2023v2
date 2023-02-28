// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;



public class Defaltdrivecammand extends CommandBase {
  private final DriveTrain m_DriveTrain;
  /** Creates a new Defaltdrivecammand. */
  public Defaltdrivecammand(DriveTrain m_DriveTrain,double leftspeed, double rightspeed) {

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



m_DriveTrain.drive(m_left.getAsDouble);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {


DriveTrain.drive_speed(speed:0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
