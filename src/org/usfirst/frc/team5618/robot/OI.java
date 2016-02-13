package org.usfirst.frc.team5618.robot;

import org.usfirst.frc.team5618.robot.commands.InBallon;
import org.usfirst.frc.team5618.robot.commands.LeverBras;
import org.usfirst.frc.team5618.robot.commands.OutBallon;
import org.usfirst.frc.team5618.robot.commands.Reculer;
import org.usfirst.frc.team5618.robot.commands.Tourner;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick stick;

	public OI() {

		stick = new Joystick(0);
		
		Button buttonA = new JoystickButton(stick, 1),
				buttonY = new JoystickButton(stick, 4),
				buttonX = new JoystickButton(stick, 3) 
				;
		
		buttonA.whenPressed(new InBallon());
		buttonY.whenPressed(new OutBallon());
		buttonX.whenPressed(new LeverBras());		
		
		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous Command Reculer", new Reculer());
		SmartDashboard.putData("Autonomous Command Tourner", new Tourner());
		SmartDashboard.putData("InPelle", new InBallon());
		SmartDashboard.putData("OutPelle", new OutBallon());
	}

	public Joystick getstick() {
		return stick;
	}

}
