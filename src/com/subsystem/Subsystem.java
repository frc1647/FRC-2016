package com.subsystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;

public class Subsystem {
	public static Joystick stick1; // operator use (many classes need)
	public static Compressor air;
	
	public Subsystem() {
		stick1 = new Joystick(1); // TODO: move whatever joystick is chosen to port 1
		air = new Compressor(0);
	}
}