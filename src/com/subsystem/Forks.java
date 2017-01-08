package com.subsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;

public class Forks extends Subsystem {
	
	private CANTalon forks;
	private AnalogInput pot;
	private String forksMode;
	
	public Forks() {
		forks = new CANTalon(5);
		pot = new AnalogInput(0);
	}
	
	public void move() {
		if(true /*getPot() < 4.406 || getPot() > 2.112*/) {
			forks.set(transformJoyInput(0.75*stick1.getRawAxis(3)));
			forksMode = "can move";
		} else {
			forks.set(0.0);
			forksMode = "bottom/top";
		}
	}
	
	public void autoMove() {
		forks.set(0.0);
	}
	
	public double getPot() {
		return pot.getVoltage();
	}
	
	public String getMode() {
		return forksMode;
	}
	
	public double transformJoyInput(double input) {
		return input;
	}
}