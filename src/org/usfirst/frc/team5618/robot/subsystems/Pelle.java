package org.usfirst.frc.team5618.robot.subsystems;

import org.usfirst.frc.team5618.robot.RobotMap;
import org.usfirst.frc.team5618.robot.commands.StopPelle;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pelle extends Subsystem {

	private final CANTalon motorPelle = RobotMap.pellemotorPelle;
	private final DigitalInput limitPelleBallon = RobotMap.pelleLimitPelleBallon;
	public final DigitalInput limitPelleHerse = RobotMap.pelleLimitPelleHerse;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void inBallon() {
		motorPelle.set(1);
	}

	public void outBallon() {
		motorPelle.set(-1);
	}

	public void ballonStop() {
		motorPelle.set(0);
	}

	public boolean limitFond() {
		return limitPelleBallon.get();
	}

	public boolean herseAcotee() {
		return limitPelleHerse.get();
	}

	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		setDefaultCommand(new StopPelle());
	}
}
