// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;





public class drive_for_Time extends CommandBase {

  private final Timer m_time = new Timer();
  private final double m_seconds;
private final DriveTrain m_DriveTrain;
private final double xSpeed;
private final double zRotation;
  /** Creates a new autobackup. */
  public drive_for_Time(DriveTrain DriveTrain, double Speed , Double Rotate, double TimeSeconds) {
this.m_seconds = TimeSeconds;
this.xSpeed = Speed;
this.zRotation = Rotate;
this.m_DriveTrain = DriveTrain;

   
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_time.restart();
    System.out.println("driveinit");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DriveTrain.Drive_Arcade_Drive(xSpeed, zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_time.get() >= m_seconds){
      return true;
    }
else
    return false;
  }
  }

