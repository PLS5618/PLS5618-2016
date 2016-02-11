package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class drive extends Command {
	public drive() {
		requires(Robot.chassis);
		
	}
	boolean front = true;

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		

		Robot.chassis.drive(Robot.oi.getstick());

		if (Robot.oi.stick.getRawButton(5)) {

			if (front) {
				Robot.chassis.changeSide(false);
				front = false;
			} else {
				Robot.chassis.changeSide(true);
				front = true;
			}
		}
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
