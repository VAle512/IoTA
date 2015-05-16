package it.uniroma3.iota.controller.action;

import it.uniroma3.iota.controller.helper.HelperTemperatureId;

import javax.servlet.http.HttpServletRequest;

public class CreateTemperature {

	public String perform(HttpServletRequest request) {

		HelperTemperature helper = new HelperTemperature();

		if (helper.isValid(request)) {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			Float price = Float.parseFloat(request.getParameter("price"));
			String description = request.getParameter("description");

			ProductFacade facade = new ProductFacade();
			Product product = facade.createProduct(name, code, price, description);
			request.setAttribute("product", product);

			return "/product.jsp";
		} else
			return "/newProduct.jsp";
	}

}
