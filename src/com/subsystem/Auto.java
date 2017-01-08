package com.subsystem;

import edu.wpi.first.wpilibj.Timer;

public class Auto extends Subsystem {
	private Drive drive;
	private Intake intake;
	private Forks forks;
	
	public Auto(Drive drive, Intake intake, Forks forks) {
		//this.drive = drive;
		this.intake = intake;
		this.forks = forks;
	}
	
	public void runAuto(int start, int defensePosition, int defense, boolean lowGoal) {
		// get to in front of proper defense
		int delta = start - defensePosition;
		switch (delta) {
			case -4:
				straight(0.5);
				right(0.5);
				straight(4);
				left(0.5);
				straight(2);
				break;
			case -3:
				straight(0.5);
				right(0.5);
				straight(3);
				left(0.5);
				straight(2);
				break;
			case -2:
				straight(0.5);
				right(0.5);
				straight(2);
				left(0.5);
				straight(2);
				break;
			case -1: // right one defense
				straight(0.5);
				right(0.5);
				straight(1);
				left(0.5);
				straight(2);
				break;
			case 0: //straight forward
				straight(2);
				break;
			case 1: // left one defense
				straight(0.5);
				left(0.5);
				straight(1);
				right(0.5);
				straight(2);
				break;
			case 2:
				straight(0.5);
				left(0.5);
				straight(2);
				right(0.5);
				straight(2);
				break;
			case 3:
				straight(0.5);
				left(0.5);
				straight(3);
				right(0.5);
				straight(2);
				break;
			case 4:
				straight(0.5);
				left(0.5);
				straight(4);
				right(0.5);
				straight(2);
				break;
		}
	}
	
	private boolean straight(double seconds) {
		Timer timer = new Timer();
		timer.start();
		while(timer.get() < seconds * 1000) {
			drive.autodrive(0.5, 0.5);
		}
		timer.stop();
		return true;
	}
	
	private boolean left(double seconds) {
		Timer timer = new Timer();
		timer.start();
		while(timer.get() < seconds * 1000) {
			drive.autodrive(-0.5, 0.5);
		}
		timer.stop();
		return true;
	}
	
	private boolean right(double seconds) {
		Timer timer = new Timer();
		timer.start();
		while(timer.get() < seconds * 1000) {
			drive.autodrive(0.5, -0.5);
		}
		timer.stop();
		return true;
	}
}