package it.uniroma3.iota.controller.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.uniroma3.iota.controller.helper.HelperTemperature;
import it.uniroma3.iota.model.ArduinoBoard;
import it.uniroma3.iota.model.Temperature;
import it.uniroma3.iota.model.TemperatureFacade;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class CreateTemperature implements Action {
	
	@EJB(beanName="tFacade")
	private TemperatureFacade tf;

	public String perform(HttpServletRequest request) {

		HelperTemperature helper = new HelperTemperature();

		if (helper.isValid(request)) {
			Double value = Double.parseDouble(request.getParameter("temperatureValue"));
			SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
			Date evaluationTime = null;
			try {
				evaluationTime = format.parse(request.getParameter("temperatureEvaluationTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
			GetArduinoBoard gab= new GetArduinoBoard();
			gab.perform(request);
			ArduinoBoard board = (ArduinoBoard)request.getAttribute("arduinoBoard");
			
			Temperature temperature = this.tf.createTemperature(board, value, evaluationTime);
			request.setAttribute("temperature", temperature);
			return "/temperature.jsp";
		} else
			return "/newTemperature.jsp";
	}
}
