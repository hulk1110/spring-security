package com.nish.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// this class will be used by other class as model
public class JwtAutheticationToken extends UsernamePasswordAuthenticationToken {

	private String token;

	public JwtAutheticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	// we don't want anything we have already passed null in constructor and we
	// don't want credential
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	// we don't want anything we have already passed null in constructor and we
	// don't want getPrincipal
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
