package com.subsystem;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon;

public class Intake extends Subsystem {
	
	private Solenoid pistons;
	private CANTalon intake;
	private boolean intakeIn;
	
	public Intake() {
		pistons = new Solenoid(0);
		intake = new CANTalon(6);
		intakeIn = false;
	}
	
	public void move() {
		intakeIn = toggleSolenoid(pistons, stick1.getRawButton(7), intakeIn);
	}
	
	public void spin() {
		intake.set(transformJoyInput(stick1.getRawAxis(1)));  // up down on left stick on second gamepad (port 1)
	}
	
	public void autoSpin() {
		intake.set(0.0);
	}
	
	public boolean getStatus() {
		return intakeIn;
	}
	
    private boolean toggleSolenoid(Solenoid piston, boolean buttonPressed, boolean buttonHeld) {
        if (buttonPressed && !buttonHeld) {
            buttonHeld = true;
            piston.set(!piston.get());
        } else if (!buttonPressed) {
            buttonHeld = false;
        }
        return buttonHeld;
    }
    
    private double transformJoyInput(double input) {
    	if(input < 0) {
    		return -0.6*input;
    	} else {
    		return -0.4*input;
    	}
    }
}