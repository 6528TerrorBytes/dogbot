// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
//import edu.wpi.first.wpilibj.GenericHID.RumbleType;

// import frc.robot.commands.Drive;
// import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {
  private static double speed = 0.5;

  public static boolean leftPressed = false;
  public static boolean rightPressed = false;

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
    //if(true){
    double right = joystick.getRawAxis(5);// * 0.3;
    //double rightJoystick = joystick.getRawAxis(5);
    //if (rightJoystick > 0.05 || -0.05 > rightJoystick) {
    //  right = rightJoystick;
    //}
    
    double left = joystick.getRawAxis(1);// * 0.3;
    //double leftJoystick = joystick.getRawAxis(5);
    //if (leftJoystick > 0.05 || -0.05 > leftJoystick) {
    //  left = leftJoystick;
    //}

    boolean safeMode = false;

    // double right = joystick.getRawAxis(1);
    // double left = joystick.getRawAxis(5);

     if (joystick.getRawAxis(3) >= 0.5) {
       speedUp();
     } else if (joystick.getRawAxis(2) >= 0.5) {
       slowDown();
     } else {
       resetSpeed();
     }

    //boolean t1val = joystick.getButtonPressed(5);
    // Matthew/Brayden: Tried to get trigger buttons working for 
    // spin but they only activate once, is there a way to get them 
    // to last until released? 
    
    if(rightPressed){
      right = 0.8;
      left = -0.8;
    } else if(leftPressed){
      right = -0.8;
      left = 0.8;
     }
    
    
    right *= speed;
    left *= speed;

    if(safeMode){
      double motorLimitSafe = 0.7;
      //In case we have people on the bot i want some sort of separate mode to make sure we dont eject a 7 year old
      if(right >= motorLimitSafe){
        right = motorLimitSafe;
      } else if (right <= -motorLimitSafe){
        right = -motorLimitSafe;
      }
      if(left >= motorLimitSafe){
        left = motorLimitSafe;
      } else if (left <= -motorLimitSafe){
        left = -motorLimitSafe;
      }
      
      //left-right > 1.5 || right-left > 1.5){
      //  idk somehow proprtionally change it so the difference is 1.5? matthew idc if this code is ugly
      //}
    }
    
    setRight(left);
    setLeft(right);
    }
    // setting rumble 
    //if (joystick.getRawAxis(5) >= 0.8){
    //  controller.setRumble(RumbleType.kRightRumble, 1.0);
    //}

    // Constants.Motors.left2.set(VictorSPXControlMode.PercentOutput, 0.5);
    /*if(false){
      //what an amazing drive code you have there time to make another one
      System.out.println("ebarbs:");
      double lSpeed = joystick.getRawAxis(1);
      double rSpeed = joystick.getRawAxis(1);
      System.out.println("elixir golem:");
      //System.out.println(joystick.getRawAxis(1));
      if (joystick.getRawAxis(4) > 0.1){
        //mess with right
        System.out.println("hh");
        System.out.println(rSpeed);
        System.out.println(lSpeed);
        rSpeed *= (1-joystick.getRawAxis(4));
      } else if (joystick.getRawAxis(4) < -0.1){
        //mess with left
        System.out.println("hh");
        System.out.println(rSpeed);
        System.out.println(lSpeed);
        lSpeed *= (1+joystick.getRawAxis(4));
      }
      
      rSpeed *= speed;
      lSpeed *= speed;

      System.out.println(rSpeed);
      System.out.println(lSpeed);


      setRight(lSpeed);
      setLeft(rSpeed);
     
     }
  }*/

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
