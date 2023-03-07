// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

// import frc.robot.subsystems.ArmSubsystem;

import frc.robot.subsystems.airmodsubsystem;
import frc.robot.commands.Arm_PIDCommand;
import frc.robot.commands.Armdrive;
import frc.robot.commands.Defaltdrivecammand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intakesubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  

private final Joystick Leftstick = new Joystick(0);
private final Joystick Rightstick = new Joystick(1);
private final Joystick Rightstick2 = new Joystick(2);

 private final DriveTrain Drive = new DriveTrain();

private final ArmSubsystem Arm = new ArmSubsystem();
private final airmodsubsystem air = new airmodsubsystem();
private final Intakesubsystem m_Intake = new Intakesubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

 air.start();

Drive.setDefaultCommand(new Defaltdrivecammand(
  Drive, 
  () -> Leftstick.getY()*-1,
  () -> Rightstick.getY()));

Arm.setDefaultCommand(new Armdrive( Arm,
() -> Rightstick2.getY()));


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


new JoystickButton(Rightstick2, 2)
.onTrue(new InstantCommand(
  () -> air.Clawn_Close()
));

new JoystickButton(Rightstick2,1)
.onTrue(new InstantCommand(
  () -> air.Clawn_Open()
));


new JoystickButton(Leftstick, 2)
.onTrue(new InstantCommand(
  () -> air.pivot_open()
));

new JoystickButton(Leftstick, 1)
.onTrue(new InstantCommand(
  () -> air.pivot_close()
));



new JoystickButton(Rightstick2, 12)
.onTrue(new InstantCommand(
  () -> air.vertical_up()
));

new JoystickButton(Rightstick2, 11)
.onTrue(new InstantCommand(
  () -> air.Vertical_down()
));


new JoystickButton(Leftstick, 3)
.onTrue(new InstantCommand(
  () -> m_Intake.Intake_In()
));

new JoystickButton(Rightstick, 4)
.onTrue(new InstantCommand(
  () -> m_Intake.Intake_out()
));


new JoystickButton(Rightstick, 11)
.onTrue(new InstantCommand(
  () -> air.armtoob_up()
));

new JoystickButton(Rightstick, 12)
.onTrue(new InstantCommand(
  () -> air.armtoob_down()
));



new JoystickButton(Rightstick2, 8)
.onTrue(new Arm_PIDCommand(Arm, Constants.Arm_PID_SETPOINT1));




  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
