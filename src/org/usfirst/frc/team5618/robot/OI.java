package org.usfirst.frc.team5618.robot;

import org.usfirst.frc.team5618.robot.commands.AvancerHerse;
import org.usfirst.frc.team5618.robot.commands.InBallon;
import org.usfirst.frc.team5618.robot.commands.OutBallon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

	public static final int JOY_AXIS_V_RIGHT = 5;

	public Joystick stick;

	public OI() {

		stick = new Joystick(0);

		Button buttonA = new JoystickButton(stick, 1), buttonY = new JoystickButton(stick, 4), buttonFL = new JoystickButton(stick, 5);

		buttonA.whenPressed(new InBallon());
		buttonY.whenPressed(new OutBallon());
		buttonFL.whenPressed(new AvancerHerse());

	}

	public Joystick getstick() {
		return stick;
	}

}
