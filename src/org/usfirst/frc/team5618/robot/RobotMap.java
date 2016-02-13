package org.usfirst.frc.team5618.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	public static CANTalon chassisdrive_fr;
	public static CANTalon chassisdrive_br;
	public static CANTalon chassisdrive_fl;
	public static CANTalon chassisdrive_bl;
	public static RobotDrive chassisdrive;
	public static CANTalon brasmotorBras;
	public static DigitalInput brasLimitBrasHaut;
	public static DigitalInput brasLimitBrasBas;
	public static CANTalon pellemotorPelle;
	public static DigitalInput pelleLimitPelleBallon;
	//public static ADXRS450_Gyro gyro;
	public static Encoder encL;
	public static Encoder encR;
	public static AnalogPotentiometer pot;

	public static void init() {
		chassisdrive_fr = new CANTalon(4);
		LiveWindow.addActuator("Chassis", "drive_fr", chassisdrive_fr);

		chassisdrive_br = new CANTalon(3);
		LiveWindow.addActuator("Chassis", "drive_br", chassisdrive_br);

		chassisdrive_fl = new CANTalon(2);
		LiveWindow.addActuator("Chassis", "drive_fl", chassisdrive_fl);

		chassisdrive_bl = new CANTalon(5);
		LiveWindow.addActuator("Chassis", "drive_bl", chassisdrive_bl);

		chassisdrive = new RobotDrive(chassisdrive_fl, chassisdrive_bl, chassisdrive_fr, chassisdrive_br);

		chassisdrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		chassisdrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		chassisdrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		chassisdrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		chassisdrive.setSafetyEnabled(true);
		chassisdrive.setExpiration(0.1);
		chassisdrive.setSensitivity(0.5);
		chassisdrive.setMaxOutput(1.0);

		brasmotorBras = new CANTalon(1);
		LiveWindow.addActuator("Bras", "motorBras", brasmotorBras);

		brasLimitBrasHaut = new DigitalInput(4);
		LiveWindow.addSensor("Bras", "LimitBrasHaut", brasLimitBrasHaut);

		brasLimitBrasBas = new DigitalInput(5);
		LiveWindow.addSensor("Bras", "LimitBrasBas", brasLimitBrasBas);

		pellemotorPelle = new CANTalon(6);
		LiveWindow.addActuator("Pelle", "motorPelle", pellemotorPelle);

		pelleLimitPelleBallon = new DigitalInput(6);
		LiveWindow.addSensor("Pelle", "LimitPelleBallon", pelleLimitPelleBallon);
		
		//gyro = new ADXRS450_Gyro();
		//LiveWindow.addSensor("Chassis", "gyro", gyro);
		
		encL = new Encoder(0, 1);
		LiveWindow.addSensor("Chassis", "encL", encL);
		
		encR = new Encoder(2, 3);
		LiveWindow.addSensor("Chassis", "encR", encR);
		
		encL.setDistancePerPulse(0.04);
		encR.setDistancePerPulse(0.04);
		
		SmartDashboard.putNumber("AutoDist", 80);
		SmartDashboard.putNumber("AutoSpd", 3);
		
		pot = new AnalogPotentiometer(0, 360, 30);
		AnalogInput ai = new AnalogInput(1);
		pot = new AnalogPotentiometer(ai, 360, 30);
		
	}
}
