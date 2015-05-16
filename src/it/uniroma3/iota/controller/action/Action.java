package it.uniroma3.iota.controller.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {

	public String perform(HttpServletRequest request);

}
