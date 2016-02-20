package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AvancerHerse extends Command {
	double speed = 0;

	public AvancerHerse() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putBoolean("LimitPelleHerse", Robot.pelle.herseAcotee());

		if (!Robot.pelle.limitPelleHerse.get()) {
			if (!(Robot.bras.distPot() < 1900)) {
				Robot.chassis.reculer(-0.5, 0);
			}
		}
		if (!(Robot.bras.distPot() > 1220) && (Robot.bras.distPot() < 1900)) {
			Robot.chassis.reculer(-0.8, 0);
		} else {
			Robot.chassis.reculer(-1, 0);
		}
	}

	// 1800

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.oi.stick.getRawButton(5);
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
