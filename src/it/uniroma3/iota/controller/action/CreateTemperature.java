package it.uniroma3.iota.controller.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import it.uniroma3.iota.controller.helper.HelperTemperature;
import it.uniroma3.iota.model.ArduinoBoard;
import it.uniroma3.iota.model.Temperature;
import it.uniroma3.iota.model.TemperatureFacade;
import javax.servlet.http.HttpServletRequest;

public class CreateTemperature implements Action {

	public String perform(HttpServletRequest request) {

		HelperTemperature helper = new HelperTemperature();

		if (helper.isValid(request)) {
			Double value = Double.parseDouble(request.getParameter("temperatureValue"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Date evaluationTime = null;
			try {
				evaluationTime = format.parse(request.getParameter("temperatureEvaluationTime"));
			} catch (ParseException e) {
				return "/newTemperature.jsp";
			}
			GetArduinoBoard gab= new GetArduinoBoard();
			gab.perform(request);
			ArduinoBoard board = (ArduinoBoard)request.getAttribute("arduinoBoard");
			
			TemperatureFacade tf = new TemperatureFacade();
			Temperature temperature = tf.createTemperature(board, value, evaluationTime);
			request.setAttribute("temperature", temperature);
			return "/confirmTemperatureCreation.jsp";
		} else
			return "/newTemperature.jsp";
	}
}
