package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AvancerHerse extends Command {

	// h1 = premier step de hauteur
	// h2 = deuxieme step de hauteur
	int h1 = 950;
	int h2 = 450;

	public AvancerHerse() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putBoolean("LimitPelleHerse", Robot.pelle.herseAcotee());

		if (!Robot.pelle.herseAcotee()) {
			// h1, h2 = hauteur pelle
			if ((Robot.bras.distPot() > h1)) {
				Robot.chassis.reculer(-0.4, 0);
			} else if ((Robot.bras.distPot() > h2) && !(Robot.bras.distPot() < h1)) {
				Robot.chassis.reculer(-0.6, 0);
			} else {
				Robot.chassis.reculer(-0.9, 0);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// boutton 5 = bumper gauche
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
