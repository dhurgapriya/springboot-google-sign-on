package com.ecommerce.bestpick;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller class to redirect to custom login page
 */
@Controller
public class LoginController {

	/**
	 * Called to redirect to login page.
	 * 
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/error")
	public ModelAndView error() {
		return new ModelAndView();
	}
}