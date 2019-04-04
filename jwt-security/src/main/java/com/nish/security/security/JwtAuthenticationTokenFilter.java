package com.nish.security.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

//	private AuthenticationManager authenticationManager;
//	
//	private JwtSuccesshandler authenticationSuccesshandler;
	
	protected JwtAuthenticationTokenFilter(String defaultFilterProcessesUrl) {
		super("/**");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	// we decode 
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}
}
