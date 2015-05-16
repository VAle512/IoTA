package it.uniroma3.iota.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperArduinoBoard {

	public boolean isValid(HttpServletRequest request) {

		String code = request.getParameter("arduinoBoardCode");
		boolean errors = false;

		if ( code == null || code.equals("")) {
			request.setAttribute("arduinoCodeErr","Code is mandatory");
			errors = true;
		}
		
		return !errors;

	}
}
