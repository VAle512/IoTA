package it.uniroma3.iota.controller.action;

import it.uniroma3.iota.controller.helper.HelperArduinoBoardId;
import it.uniroma3.iota.model.ArduinoBoard;
import it.uniroma3.iota.model.ArduinoBoardFacade;
import javax.servlet.http.HttpServletRequest;

public class GetArduinoBoard implements Action{

	public String perform(HttpServletRequest request) {

		HelperArduinoBoardId helper = new HelperArduinoBoardId();

		if (helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("arduinoBoardId"));

			ArduinoBoardFacade facade = new ArduinoBoardFacade();
			ArduinoBoard arduinoBoard = facade.getArduinoBoard(id);
			request.setAttribute("arduinoBoard", arduinoBoard);

			return "/arduinoBoard.jsp";
		} 
		else
			return "/getArduino.jsp";
	}
}
