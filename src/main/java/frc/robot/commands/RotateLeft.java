// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;

public class RotateLeft extends CommandBase {
  /** Creates a new RotateLeft. */
  public RotateLeft() {
    // Use addRequirements() here to declare subsystem dependencies.
    //System.out.println("royal recruits");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.leftPressed = true;
    //System.out.println("hehehehaw");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.leftPressed = false;
    //System.out.println("eheheauhui sad king tower noises");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
