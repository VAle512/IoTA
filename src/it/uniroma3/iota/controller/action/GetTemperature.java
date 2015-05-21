package it.uniroma3.iota.controller.action;

import it.uniroma3.iota.controller.helper.HelperTemperatureId;
import it.uniroma3.iota.model.Temperature;
import it.uniroma3.iota.model.TemperatureFacade;

import javax.servlet.http.HttpServletRequest;

public class GetTemperature implements Action {

		public String perform(HttpServletRequest request) {

			HelperTemperatureId helper = new HelperTemperatureId();

			if (helper.isValid(request)) {
				Long id = Long.parseLong(request.getParameter("temperatureId"));
				TemperatureFacade facade = new TemperatureFacade();
				Temperature t = facade.getTemperature(id);
				request.setAttribute("temperature",t);

				return "/temperature.jsp";
			} 
			else
				return "/getTemperature.jsp";
		}
}
