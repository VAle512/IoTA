package it.uniroma3.iota.controller.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.uniroma3.iota.controller.helper.HelperTemperature;
import it.uniroma3.iota.controller.helper.HelperTemperatureId;
import it.uniroma3.iota.model.ArduinoBoard;
import it.uniroma3.iota.model.Temperature;
import it.uniroma3.iota.model.TemperatureFacade;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class CreateTemperature {
	
	@EJB(beanName="tFacade")
	private TemperatureFacade tf;

	public String perform(HttpServletRequest request) {

		HelperTemperature helper = new HelperTemperature();

		if (helper.isValid(request)) {
			Double value = Double.parseDouble(request.getParameter("temperatureValue"));
			SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
			Date evaluationTime = format.parse(request.getParameter("temperatureEvaluationTime"));
			GetArduinoBoard = new GetArduinoBoard();
			ArduinoBoard board = GetArduinoBoard.perform(request);
			
			Temperature temperature = this.tf.createTemperature(board, value, evaluationTime);
			request.setAttribute("temperature", temperature);
			return "/temperature.jsp";
		} else
			return "/newTemperature.jsp";
	}

}
