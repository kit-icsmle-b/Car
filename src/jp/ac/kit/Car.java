package jp.ac.kit;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.ColorHTSensor;
import lejos.util.Delay;


public class Car {
	static ColorHTSensor CSensor = new ColorHTSensor( SensorPort.S1 );
	 static NXTRegulatedMotor LWheel = Motor.C;  // 左モータ
	 static NXTRegulatedMotor RWheel = Motor.A;  // 右モータ
	 
	    public static void main( String[] args ) {

	    	while ( ! Button.ESCAPE.isDown() ) {
	    		LWheel.forward(); RWheel.forward();
	    		keepLeft();
	    		if(CSensor.getColorID() == 7){	    			
	    			keepRight();	    			
	    		}
	    	}
	    	Delay.msDelay(4);
	  }
	



public static void keepLeft(){

	if(CSensor.getColor().getRed()<=10 && CSensor.getColor().getGreen()<=10 && CSensor.getColor().getBlue()<=10){
		LWheel.setSpeed(0); RWheel.setSpeed(100);
	}else{
		LWheel.setSpeed(100); RWheel.setSpeed(0);
	}
}
public static void keepRight(){

	if(CSensor.getColor().getRed()>30 && CSensor.getColor().getGreen()>30 && CSensor.getColor().getBlue()>30){
		LWheel.setSpeed(100); RWheel.setSpeed(0);
	}else{
		LWheel.setSpeed(0); RWheel.setSpeed(100);
	}
}

}