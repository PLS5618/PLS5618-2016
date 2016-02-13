package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BrasCommand extends Command {

	public BrasCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.bras);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double pourcentM;
		double pourcentB;

		if (Robot.oi.stick.getRawButton(6)) {
			pourcentM = 0.90;
			pourcentB = 0.45;
		} else {
			pourcentM = 0.45;
			pourcentB = 0.15;
		}

		if (Robot.oi.stick.getRawAxis(5) < -0.1) {
			if (Robot.bras.switchHaut() /*|| !(Robot.bras.distPot() >= (valeur choisi))*/) {
				Robot.bras.controlBras(Robot.oi.stick.getRawAxis(5) * pourcentM);
			} else {
				Robot.bras.controlBras(0);
			}
		}
		if (Robot.oi.stick.getRawAxis(5) > 0.1) {
			if (Robot.bras.switchBas()) {
				Robot.bras.controlBras(Robot.oi.stick.getRawAxis(5) * pourcentB);
			} else {
				Robot.bras.controlBras(0);
			}
		}
Timer.delay(0.01);
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
