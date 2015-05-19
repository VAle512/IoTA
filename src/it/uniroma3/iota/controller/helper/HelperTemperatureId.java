package it.uniroma3.iota.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperTemperatureId {
	public boolean isValid(HttpServletRequest request) {

		String id = request.getParameter("temperatureId");
		boolean errors = false;

		if ( id == null || id.equals("")) {
			request.setAttribute("temperatureIdErr","Invalid id");
			errors = true;
		}
		else {
			try{
				Long.parseLong(id);
			}
			catch (NumberFormatException e) {
				request.setAttribute("temperatureIdErr","Invalid id");
				errors = true;
			}
		}
		return !errors;
	}
}
