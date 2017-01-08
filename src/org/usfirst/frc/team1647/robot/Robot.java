
package org.usfirst.frc.team1647.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import java.awt.List;
import java.io.UnsupportedEncodingException;

import com.subsystem.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.SerialPort;
import java.nio.ByteBuffer;

public class Robot extends SampleRobot {
	Drive drive = new Drive();
    Messenger messenger = new Messenger();
    Intake intake = new Intake();
    Forks forks = new Forks();
    private I2C i2c = new I2C(Port.kMXP, 4);
    String robotStatus;
    Auto auto;
	
    public Robot() {
    	
    }
    
    public void robotInit() {
    	//Subsystem.air.start();
    }

    public void autonomous() {
    	robotStatus = "auto";
    	Timer timer = new Timer();
    	timer.start();
    	while(timer.get() < 4) {
    		drive.autoDrive();
    		intake.autoSpin();
    		forks.autoMove();
    	}
    	//while(timer.get() < 5) {
    		//drive.autoRoughDrive();
    	//}
    	
    	/*while(timer.get() < 3) { // rock wall
    		drive.autodrive(1.0,1.0);
    	}*/

    }

    public void operatorControl()  {
    	robotStatus = "teleop";
        while (isOperatorControl() && isEnabled()) {
        	drive.drive();
        	intake.move();
        	intake.spin();
        	forks.move();
        	//Timer.delay(0.005);		// wait for a motor update time
            messenger.setData(0.0, forks.getPot(), true, intake.getStatus(), forks.getMode(), robotStatus);
            messenger.putData();
            //String WriteString = "go";
            //byte[] RecData = new byte[6];
            //char[] CharArray = WriteString.toCharArray();
            //byte[] WriteData = new byte[CharArray.length];
            //for(int i = 0; i < CharArray.length; i++) {
            	//WriteData[i] = (byte) CharArray[i];
            //}
            //i2c.transaction(WriteData, WriteData.length, RecData, 6);
            ///System.out.println("RIODUINO: " + RecData + " after");
            //String s = new String(RecData, "UTF-8");
        }
    }
}