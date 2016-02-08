package org.usfirst.frc.team5618.robot.subsystems;

import org.usfirst.frc.team5618.robot.commands.CameraCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CameraCommand());
    }
}

