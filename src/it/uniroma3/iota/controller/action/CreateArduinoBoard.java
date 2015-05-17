package it.uniroma3.iota.controller.action;

import it.uniroma3.iota.controller.helper.HelperArduinoBoard;
import it.uniroma3.iota.model.ArduinoBoard;
import it.uniroma3.iota.model.ArduinoBoardFacade;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class CreateArduinoBoard implements Action{
	
	@EJB(beanName="aFacade")
	private ArduinoBoardFacade facade;

	public String perform(HttpServletRequest request) {

		HelperArduinoBoard helper = new HelperArduinoBoard();

		if (helper.isValid(request)) {
			String code = request.getParameter("arduinoBoardCode");

			ArduinoBoard arduinoBoard = this.facade.createArduinoBoard(code);
			request.setAttribute("arduinoBoard", arduinoBoard);

			return "/arduinoBoard.jsp";
		} else
			return "/newArduinoBoard.jsp";
	}
}
