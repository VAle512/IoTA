package it.uniroma3.iota.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperArduinoBoardId {

	public boolean isValid(HttpServletRequest request) {

		String id = request.getParameter("arduinoBoardId");
		boolean errors = false;

		if ( id == null || id.equals("")) {
			request.setAttribute("arduinoBoardIdErr","Invalid id");
			errors = true;
		}
		else {
			try{
				Long.parseLong(id);
			}
			catch (NumberFormatException e) {
				request.setAttribute("arduinoBoardId","Invalid id");
				errors = true;
			}
		}
		return !errors;
	}

}
