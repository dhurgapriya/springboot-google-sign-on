package com.ecommerce.bestpick;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * CustomAuthenticationSuccessHandler which can be configured with a default URL
 * which users should be sent to upon successful authentication.
 * 
 */
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private BestPickService bestPickService;

	/**
	 * To forward or redirect to the target URL upon successful authentication
	 */

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {

		OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();
		String userName = principal.getAttribute("given_name");
		String userId = principal.getAttribute("email");

		// Get the user details for the authenticated user
		String userRole = bestPickService.findUser(userId);

		// For registered users
		if (userRole != null && !"".equalsIgnoreCase(userRole)) {
			if ("consumer".equalsIgnoreCase(userRole)) {
				httpServletResponse.sendRedirect("/consumer/" + userName + "/" + userId);
			} else if ("seller".equalsIgnoreCase(userRole)) {
				httpServletResponse.sendRedirect("/seller/" + userName + "/" + userId);
			}
		}
		// For new users
		else {
			httpServletResponse.sendRedirect("/edit/" + userName + "/" + userId);
		}

	}
}