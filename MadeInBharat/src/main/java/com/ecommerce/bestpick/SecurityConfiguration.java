package com.ecommerce.bestpick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The custom security configuration for web security. It relies on Spring
 * Security's content-negotiation strategy to determine what sort of
 * authentication to use.
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String LOGIN_URL = "/login";

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	/**
	 * This method overrides the default configure method to create a customized
	 * login and to specify rules for the endpoints .
	 *
	 * @param http
	 *            the httpSecurity to modify
	 * @throws Exception
	 *             if an error occurs
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
				// Allow only /login request.
				.authorizeRequests().antMatchers(LOGIN_URL).permitAll()
				// Restrict access to our application.
				.anyRequest().authenticated()
				// Not using Spring CSRF here to be able to use plain HTML for the login page
				.and().csrf().disable()
				// Configure the login page with OAuth.
				.oauth2Login().loginPage(LOGIN_URL)
				// Redirect page after successful login
				.successHandler(customAuthenticationSuccessHandler).permitAll();
	}

}
