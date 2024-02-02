// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

// import frc.robot.commands.Drive;
// import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {
  private static double speed = 0.5;

  public static void speedUp()    { speed = 0.8;  }
  public static void resetSpeed() { speed = 0.5;  }
  public static void slowDown()   { speed = 0.25; }

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(Joystick joystick) {
    double right = joystick.getRawAxis(5);
    double left = joystick.getRawAxis(1);

    if (joystick.getRawAxis(3) >= 0.5) {
      speedUp();
    } else if (joystick.getRawAxis(2) >= 0.5) {
      slowDown();
    } else {
      resetSpeed();
    }
    
    right *= speed;
    left *= speed;
    
    setRight(left);
    setLeft(right);

    // Constants.Motors.left2.set(VictorSPXControlMode.PercentOutput, 0.5);
  }

  public void setLeft(double speed) {
    Constants.Motors.left1.set(VictorSPXControlMode.PercentOutput, speed);
    Constants.Motors.left2.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void setRight(double speed) {
    Constants.Motors.right1.set(VictorSPXControlMode.PercentOutput, -speed);
    Constants.Motors.right2.set(VictorSPXControlMode.PercentOutput, -speed);
  }

  public void stop() {
    
  }
}
