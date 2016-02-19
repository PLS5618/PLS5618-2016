package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Reculer extends Command {
	
	double AutoSpeed;
	double speed;
	
    public Reculer() {
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.encReset();
    	Robot.chassis.resetGyro();
    	AutoSpeed = SmartDashboard.getNumber("AutoSpd");
    	speed = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	AutoSpeed = SmartDashboard.getNumber("AutoSpd");
    	//Kp = CORRECTION
    	double Kp = 0.5;
    	
    	if (Robot.chassis.spdEncoder() < (AutoSpeed - 0.001)) {
    		speed = speed - 0.01;
    	}
    	if (Robot.chassis.spdEncoder() > (AutoSpeed + 0.001)) {
    		speed = speed + 0.01;
    	}
    	    	
    	SmartDashboard.putNumber("gyroAngle", Robot.chassis.valeurGyro());
    	
    	Robot.chassis.reculer(speed, (-Robot.chassis.valeurGyro() * Kp));
    	Timer.delay(0.001);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.chassis.distEncoder() <= SmartDashboard.getNumber("AutoDist");
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
