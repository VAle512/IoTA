package it.uniroma3.iota.controller.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

public class HelperTemperature {

	public boolean isValid(HttpServletRequest request) {

		String value = request.getParameter("TemperatureValue");
		String evaluationTime = request.getParameter("TemperatureEvaluationTime");
		boolean errors = false;

		if ( value == null || value.equals("")) {
			request.setAttribute("temperatureValueErr","value is mandatory");
			errors = true;
		}
		else {
			try{
				Double.parseDouble(value);
			}
			catch (NumberFormatException e) {
				request.setAttribute("temperatureValueErr","Value must be a number");
				errors = true;
			}
		}

		if ( evaluationTime== null || evaluationTime.equals("")) {
			request.setAttribute("temperatureEvaluationTimeErr","Evaluation time is mandatory");
			errors = true;
		}
		else
			try{
				SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
				format.parse(request.getParameter("temperatureEvaluationTime"));
			}
		catch(ParseException e) {
			request.setAttribute("temperatureEvaluationTimeErr","Evaluation time format must be: yyyy.MM.dd G HH:mm:ss");
			errors = true;
		}

		HelperArduinoBoardId helper = new HelperArduinoBoardId();
		if(!helper.isValid(request))
			errors = false;

		return !errors;
	}
}
