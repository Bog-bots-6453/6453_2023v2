// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

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
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.drive_for_Time;



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


SendableChooser<Command> autoChooser = new SendableChooser<>();

private Command m_autoSelected;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    ShuffleboardTab autoTab = Shuffleboard.getTab("Autonomous");
 air.start();

Drive.setDefaultCommand(new Defaltdrivecammand(
  Drive, 
  () -> Leftstick.getY()*-1,
  () -> Rightstick.getY()));

Arm.setDefaultCommand(new Armdrive( Arm,
() -> Rightstick2.getY()));


    // Configure the button bindings
    configureButtonBindings();

CameraServer.startAutomaticCapture();

    autoChooser.setDefaultOption("Backup_For_Time_Default()", Backup_For_Time_Default());
          autoChooser.addOption("auto_2", auto_2());
          autoChooser.addOption("auto_3", auto_3());

          autoTab.add(autoChooser);

    
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


new JoystickButton(Rightstick2, 4)
.onTrue(new InstantCommand(
  () -> air.pivot_open()
));

new JoystickButton(Rightstick2, 3)
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


new JoystickButton(Leftstick, 1)
.onTrue(new InstantCommand(
 () -> m_Intake.Intake_In()
  

))
.onFalse(new InstantCommand(
() -> m_Intake.Intake_stop()) // added to try to stop motors when released
);

new JoystickButton(Rightstick, 1)
.onTrue(new InstantCommand(
  () -> m_Intake.Intake_out()
))
.onFalse(new InstantCommand(()-> m_Intake.Intake_stop()) // added to try to stop motors when released
);



new JoystickButton(Rightstick, 2)
.onTrue(new InstantCommand(
  () -> m_Intake.Intake_stop()
));









new JoystickButton(Rightstick, 3)
.onTrue(new InstantCommand(
  () -> air.armtoob_up()
));

new JoystickButton(Rightstick, 4)
.onTrue(new InstantCommand(
  () -> air.armtoob_down()
));



new JoystickButton(Rightstick2, 5)
.onTrue(new Arm_PIDCommand(Arm, Constants.Arm_PID_SETPOINT1));

new JoystickButton(Rightstick2, 6)
.onTrue(new Arm_PIDCommand(Arm, Constants.Arm_PID_SETPOINT2));


new Trigger(()->
{if(Math.abs(Rightstick2.getY())>.05)
return true;
else{return false;}


}

).onTrue(new Armdrive(Arm, ()->Rightstick2.getY()));


  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

private Command Backup_For_Time_Default(){

  return new SequentialCommandGroup( // every command line below gets a "," except the last commnand  -- last line is a ");"
    new drive_for_Time( Drive, -.5, 0.0 , 2), // Drive at -.5 speed, zero rotate, for 2 Seconds
    new drive_for_Time(Drive, 0.0, .25, 1), // rotate at .25 speed for 1 second
    new drive_for_Time(Drive, 0.0, .25, 1)
  );
}



private Command auto_2(){
  return null; // replace null with // new SequentialCommandGroup(    );
}



private Command auto_3(){
  return null; // replace null with // new SequentialCommandGroup(    );
}


  public Command getAutonomousCommand() {
    m_autoSelected = autoChooser.getSelected();
    
    System.out.println("Auto selected: " + m_autoSelected);
System.out.println("auto Run");

return m_autoSelected;
  }
}
