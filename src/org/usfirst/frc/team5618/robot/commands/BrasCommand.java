package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BrasCommand extends Command {
	double joySpeed;
	double speed;
	double SpdMax;

	public BrasCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.bras);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// VITESSE MAXIMALE (DANS LE DASHBOARD (VOIR ROBOTMAP))
		SpdMax = SmartDashboard.getNumber("BrasSpd");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		// double pourcentM;
		// double pourcentB;
		/*
		 * if (Robot.oi.stick.getRawButton(6)) { pourcentM = 0.90; pourcentB =
		 * 0.45; } else { pourcentM = 0.45; pourcentB = 0.15; }
		 */

		// REFRESH ALL VARIABLES
		SmartDashboard.putNumber("distPot", Robot.bras.distPot());
		joySpeed = Robot.oi.stick.getRawAxis(5);

		// INCREASE/DECREASE SPEED IF NOT CORRECT
		if (Robot.bras.BrasSpd() >= joySpeed * SpdMax && speed >= -1) {
			speed -= 0.01;
		} else if (Robot.bras.BrasSpd() <= joySpeed * SpdMax && speed <= 1) {
			speed += 0.01;
		}

		// 0.1 ET -0.1 = DEADZONE
		if (Robot.oi.stick.getRawAxis(5) < -0.1) {
			if (Robot.bras.switchHaut() && !(Robot.bras.distPot() <= (SmartDashboard.getNumber("hMax")))) {
				// SET SPEED TO MOTORS
				Robot.bras.controlBras(speed);
			} else {
				Robot.bras.controlBras(0);
			}
		} else if (Robot.oi.stick.getRawAxis(5) > 0.1) {
			if (Robot.bras.switchBas()) {
				Robot.bras.controlBras(speed);
			} else {
				Robot.bras.controlBras(0);
			}
		} else
			Robot.bras.controlBras(0);

		Timer.delay(0.001);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
