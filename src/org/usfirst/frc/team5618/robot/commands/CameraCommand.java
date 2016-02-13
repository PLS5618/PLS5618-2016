package org.usfirst.frc.team5618.robot.commands;

import org.usfirst.frc.team5618.robot.Robot;

import com.ni.vision.NIVision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CameraCommand extends Command {

    public CameraCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	boolean laswitch = Robot.oi.stick.getRawButton(5);
		
		if (laswitch) {
			if (Robot.currSession == Robot.sessionfront) {
				NIVision.IMAQdxStopAcquisition(Robot.currSession);
				Robot.currSession = Robot.sessionback;
				NIVision.IMAQdxConfigureGrab(Robot.currSession);
				laswitch = false;
			} else if (Robot.currSession == Robot.sessionback) {
				NIVision.IMAQdxStopAcquisition(Robot.currSession);
				Robot.currSession = Robot.sessionfront;
				NIVision.IMAQdxConfigureGrab(Robot.currSession);
				laswitch = false;
			}
		}

		NIVision.IMAQdxGrab(Robot.currSession, Robot.frame, 1);
		CameraServer.getInstance().setImage(Robot.frame);
		
		Timer.delay(0.05);
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
