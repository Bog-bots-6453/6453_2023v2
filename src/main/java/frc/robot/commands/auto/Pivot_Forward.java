// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.airmodsubsystem;

public class Pivot_Forward extends CommandBase {
  private final airmodsubsystem m_AirMod;
  private final boolean m_true;
  /** Creates a new ClawOpen. */
  public Pivot_Forward(airmodsubsystem m_AirMod,boolean Open) {
this.m_true = Open;
    this.m_AirMod = m_AirMod;

    addRequirements(m_AirMod);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
if (m_true){

  m_AirMod.pivot_open();
}
else

m_AirMod.pivot_close();



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}

