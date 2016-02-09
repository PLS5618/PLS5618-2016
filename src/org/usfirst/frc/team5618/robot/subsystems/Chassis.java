// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team5618.robot.subsystems;

import org.usfirst.frc.team5618.robot.RobotMap;
import org.usfirst.frc.team5618.robot.commands.drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

	private final CANTalon drive_fr = RobotMap.chassisdrive_fr;
	private final CANTalon drive_br = RobotMap.chassisdrive_br;
	private final CANTalon drive_fl = RobotMap.chassisdrive_fl;
	private final CANTalon drive_bl = RobotMap.chassisdrive_bl;
	private final RobotDrive drive = RobotMap.chassisdrive;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void drive(Joystick stick) {
		drive.arcadeDrive(stick);
	}

	public void changeSide(boolean side) {
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, side);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, side);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, side);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, side);

		if (side) {
			RobotMap.chassisdrive = new RobotDrive(drive_fl, drive_bl, drive_fr, drive_br);
		} else {
			RobotMap.chassisdrive = new RobotDrive(drive_fr, drive_br, drive_fl, drive_bl);
		}
	}

	public void stop() {
		drive.arcadeDrive(0, 0);
	}

	public void reculer() {
		drive_fr.set(0.4);
		drive_br.set(0.4);
		drive_fl.set(0.4);
		drive_bl.set(0.4);
		}
	
	public void tourner() {
		drive_fr.set(-0.4);
		drive_br.set(-0.4);
		drive_fl.set(0.4);
		drive_bl.set(0.4);
	}
	
	public void initDefaultCommand() {

		setDefaultCommand(new drive());

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
