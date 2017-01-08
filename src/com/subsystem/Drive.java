package com.subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;

public class Drive extends Subsystem {
	private CANTalon talon1;
	private CANTalon talon2;
	private CANTalon talon3;
	private CANTalon talon4;
	private RobotDrive drive;
	private Joystick ps3;
	
	public Drive() {
		talon1 = new CANTalon(1);
		talon2 = new CANTalon(2);
		talon3 = new CANTalon(3);
		talon4 = new CANTalon(4);
		drive = new RobotDrive(talon3, talon4, talon1, talon2);
		ps3 = new Joystick(0);
	}
	
	public void autoDrive() {
		drive.tankDrive(0.65, 0.65);
	}
	
	public void autoRoughDrive() {
		drive.tankDrive(1, 1);
	}
	
	
	public void drive() { // teleop TODO: implement PID control?
		double left = ps3.getRawAxis(1);
		double right = ps3.getRawAxis(3);		
		drive.tankDrive(-transformJoyInput(left), -transformJoyInput(right), false);
	}
	
	public void autodrive(double leftPower, double rightPower) {  // auto only
		drive.tankDrive(leftPower, rightPower);
	}
	
	private double transformJoyInput(double input) {
		final double JOY_SCALE = 0.5208333;
		return (JOY_SCALE)*Math.pow(input, 3) + (1 - JOY_SCALE)*input;
	}
}