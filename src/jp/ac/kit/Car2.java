package jp.ac.kit;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.ColorHTSensor;
import lejos.util.Delay;

public class Car2 {
	 static ColorHTSensor CSensor = new ColorHTSensor( SensorPort.S1 );
	 static NXTRegulatedMotor LWheel = Motor.C;  // 左モータ
	 static NXTRegulatedMotor RWheel = Motor.A;  // 右モータ
	 static int 	Count;
	    public static void main( String[] args ) {
	    	runRight();
	    }

	    public static void runRight(){
	    	Count=0;
	    	while ( ! Button.ESCAPE.isDown() ) {
	    		 LCD.clear();
	    	if(CSensor.getColor().getRed()==0 && CSensor.getColor().getGreen()==0 && CSensor.getColor().getBlue()==0){
            	turnRight();
          	    	}else /*if(CSensor.getColor().getRed()>30 && CSensor.getColor().getGreen()>30 && CSensor.getColor().getBlue()>40)*/{
          	    		turnLeft();
          	    	}
	    	if(CSensor.getColor().getRed()>=5 && CSensor.getColor().getRed()<=8 &&CSensor.getColor().getGreen()<=18 &&CSensor.getColor().getGreen()>=14&& CSensor.getColor().getBlue()>=5&& CSensor.getColor().getBlue()<=8){
	    		Count++;
	    		if(Count>2)
	    			/*Forward();
	    			Delay.msDelay( 500 );*/
	    			runLeft(); 
	    	}
	    	LCD.refresh();
	    	//Delay.msDelay( 25 );
	    }
	    }
	    public static void runLeft(){
	    	Count=0;
	    	
	    	while ( ! Button.ESCAPE.isDown() ) {
	    		 LCD.clear();
	    	if(CSensor.getColor().getRed()==0 && CSensor.getColor().getGreen()==0 && CSensor.getColor().getBlue()==0){
	    		turnLeft();
	    	}else /*if(CSensor.getColor().getRed()>15 && CSensor.getColor().getGreen()>15 && CSensor.getColor().getBlue()>20)*/{
	    		turnRight();
	    	}
	    	if(CSensor.getColor().getRed()>=5 && CSensor.getColor().getRed()<=8 &&CSensor.getColor().getGreen()<=18 &&CSensor.getColor().getGreen()>=14&& CSensor.getColor().getBlue()>=5&& CSensor.getColor().getBlue()<=8){
	    		Count++;
	    		if(Count>2)
	    			/*Forward();
	    			Delay.msDelay( 500 );*/
	    			runRight();
	    	}
	    	LCD.refresh();
	    	//Delay.msDelay( 25 );
	    }
	    }
	    
public static void turnRight(){
	LWheel.setSpeed(150); RWheel.setSpeed(0);
	LWheel.forward(); RWheel.forward();
}

public static void turnLeft(){
	LWheel.setSpeed(0); RWheel.setSpeed(150);
	LWheel.forward(); RWheel.forward();
}

public static void Stop(){
	LWheel.stop(true); RWheel.stop();
}
public static void Forward(){
	LWheel.setSpeed(550); RWheel.setSpeed(550);
	LWheel.forward(); RWheel.forward();
}
}
