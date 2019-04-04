package com.nish.security.security;

import org.springframework.stereotype.Component;

import com.nish.security.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "youTube";

	public JwtUser validate(String token) {
		// TODO Auto-generated method stub
		JwtUser jwtUser = null;
		try {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		jwtUser.setUserName(body.getSubject());
		jwtUser.setId(Long.parseLong((String) body.get("userId")));
		jwtUser.setRole((String) body.get("role"));
		return jwtUser;
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
		return jwtUser;

}
}