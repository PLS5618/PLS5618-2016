package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class changeSide extends Command {
	boolean front = true;
	boolean changed = false;

    public changeSide() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	changed = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
			if (front) {
				Robot.chassis.changeSide(false);
				front = false;
			} else {
				Robot.chassis.changeSide(true);
				front = true;
		}
			changed = true;
			
			Timer.delay(0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return changed;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
