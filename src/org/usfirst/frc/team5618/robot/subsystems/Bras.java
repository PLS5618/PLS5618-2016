package org.usfirst.frc.team5618.robot.subsystems;

import org.usfirst.frc.team5618.robot.RobotMap;
import org.usfirst.frc.team5618.robot.commands.BrasCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Bras extends Subsystem {
	private final CANTalon motorBras = RobotMap.brasmotorBras;
	private final DigitalInput limitBrasHaut = RobotMap.brasLimitBrasHaut;
	private final DigitalInput limitBrasBas = RobotMap.brasLimitBrasBas;
	private final AnalogPotentiometer pot = (AnalogPotentiometer) RobotMap.pot;
	private final Encoder encPelle = RobotMap.encPelle;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void controlBras(double spd) {
		motorBras.set(-spd);
	}

	public boolean switchHaut() {
		return limitBrasHaut.get();
	}

	public boolean switchBas() {
		return limitBrasBas.get();
	}

	public void baisserBras() {
		motorBras.set(-0.2);
	}

	public double distPot() {
		return pot.get();
	}

	public void LeverBras(){
		motorBras.set(0.6);
	}
	
	public double BrasSpd() {
		return encPelle.getRate();
	}
	
	public void initDefaultCommand() {

		setDefaultCommand(new BrasCommand());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
