package org.usfirst.frc.team5618.robot.subsystems;

import org.usfirst.frc.team5618.robot.RobotMap;
import org.usfirst.frc.team5618.robot.commands.drive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
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
	private final ADXRS450_Gyro gyro = RobotMap.gyro;
	private final Encoder encL = RobotMap.encL;
	private final Encoder encR = RobotMap.encR;

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

	public void reculer(double speed, double curve) {
		drive.arcadeDrive(-0.3, 0);
	}

	public void tourner() {
		drive.arcadeDrive(0, 0.3);
	}

	public double valeurGyro() {
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
	}

	public double distEncoder() {
		return (encL.getDistance() + encR.getDistance()) / 2;
	}

	public double spdEncoder() {
		return (encL.getRate() + encR.getRate()) / 2;
	}

	public void encReset() {
		encL.reset();
		encR.reset();
	}

	public void initDefaultCommand() {

		setDefaultCommand(new drive());

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
