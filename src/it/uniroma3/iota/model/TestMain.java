package it.uniroma3.iota.model;

import java.util.Calendar;
import java.util.Date;

public class TestMain {
	
	public static void main(String args[]){
		ArduinoBoardFacade facade = new ArduinoBoardFacade();
		ArduinoBoard b = facade.getArduinoBoard(new Long(1));
		ArduinoBoardFacade facade2 = new ArduinoBoardFacade();
		facade2.createArduinoBoard("testAle2");
		System.out.println(b.toString());
		Long x = Long.parseLong("151");
		Long y = x + new Long(1);
		System.out.println(y.toString());
		Date time = new Date();
		time.setYear(2015);
		time.setMonth(Calendar.FEBRUARY);
		time.setDate(1);
		time.setHours(11);
		time.setMinutes(30);
		time.setSeconds(34);
		TemperatureFacade f = new TemperatureFacade();
		f.createTemperature(b, new Double(10), time);
		System.out.println("Inserito!");
	}

}
