package it.uniroma3.iota.controller.action;



import it.uniroma3.iota.controller.helper.HelperArduinoBoardId;
import it.uniroma3.iota.model.ArduinoBoard;
import it.uniroma3.iota.model.ArduinoBoardFacade;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class GetArduinoBoard implements Action{

	@EJB(beanName="aFacade")
	private ArduinoBoardFacade facade;
	
	public String perform(HttpServletRequest request) {

		HelperArduinoBoardId helper = new HelperArduinoBoardId();

		if (helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));

			ArduinoBoard arduinoBoard = facade.getArduinoBoard(id);
			request.setAttribute("arduinoBoard", arduinoBoard);

			return "/arduinoBoard.jsp";
		} else
			return "/invalid.jsp";
	}

}
