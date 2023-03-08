// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

//import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ArmSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Arm_PIDCommand extends CommandBase {

  private PIDController m_ArmPIDController;
  private final ArmSubsystem m_ArmSubsystem;
  private double setPoint;

  /** Creates a new Arm_PIDCommand. */
  public Arm_PIDCommand(ArmSubsystem m_ArmSubsystem, double setPoint) {
    this.m_ArmSubsystem = m_ArmSubsystem;
    this.m_ArmPIDController = new PIDController(0.004, .000000000, 0.0);
    this.setPoint = setPoint;
   addRequirements(m_ArmSubsystem);
   
    // super(
    //     // The controller that the command will use
    //     new PIDController(0, 0, 0),
    //     // This should return the measurement
    //     () -> 0,
    //     // This should return the setpoint (can also be a constant)
    //     () -> 0,
    //     // This uses the output
    //     output -> {
    //       // Use the output here
    //     });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }
  public void execute() 
  {
    double feedforward = -0.05;
    double speed = m_ArmPIDController.calculate(m_ArmSubsystem.getAbsoluteEncoderCounts(), setPoint);
    speed = (speed > 0) ? speed + feedforward : speed - feedforward;
    speed = (speed > 1 ) ? 1.0 : speed;
    speed = (speed < -1 ) ? -1 : speed; 
    m_ArmSubsystem.Arm_Speed(speed* Constants.Arm_PID_Speed);
    SmartDashboard.putNumber("Arm output: ", speed);
    
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_ArmPIDController.atSetpoint())
          return true;
    return false;

  }


  public void end(boolean interrupted) 
  {
    m_ArmSubsystem.Arm_Speed(0);
  }






  public void setPoint(double setPoint)
  {
    this.setPoint = setPoint;
  }

}
