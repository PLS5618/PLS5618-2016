package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BaisserBras extends Command {
	boolean finish = false;
    public BaisserBras() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.bras.baisserBras();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// 2230 = VALEUR DU POTENTIOMETRE MAX
        return (Robot.bras.distPot() >= 1770) || !SmartDashboard.getBoolean("baisserBras");
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
