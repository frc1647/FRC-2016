package com.subsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Messenger extends Subsystem {
	
	private double targetForksPosition;
	private double potVoltage;
	private boolean forksAtLocation;
	private boolean intakeEngaged;
	private String forksMode;
	private String robotStatus;
	
	public Messenger() {
		DriverStation.getInstance();
	}
	
	public void putData() {
		try {
			SmartDashboard.putNumber("Target Forks Position", targetForksPosition);
			SmartDashboard.putNumber("Forks Current Voltage", potVoltage); // check
			SmartDashboard.putBoolean("Forks At Location", forksAtLocation);
			SmartDashboard.putBoolean("Intake Engaged", intakeEngaged); // check
			SmartDashboard.putString("Forks Mode", forksMode); // check
			SmartDashboard.putString("Robot Status", robotStatus); // check
		} catch (Exception e) {
			System.out.println("SmartDash not able to put data");
		}
	}
	
	public void setData(double targetForksPosition, double potVoltage, boolean forksAtLocation, boolean intakeEngaged, String forksMode, String robotStatus) {
		this.targetForksPosition = targetForksPosition;
		this.potVoltage = potVoltage;
		this.forksAtLocation = forksAtLocation;
		this.intakeEngaged = intakeEngaged;
		this.forksMode = forksMode;
		this.robotStatus = robotStatus;
	}
}