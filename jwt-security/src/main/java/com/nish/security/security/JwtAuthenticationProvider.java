package com.nish.security.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.nish.security.model.JwtAutheticationToken;
import com.nish.security.model.JwtUser;
import com.nish.security.model.JwtUserDetails;

// all major process are done here
// we authenticate all class
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator jwtValidator;
	

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return (JwtAutheticationToken.class.isAssignableFrom(aClass));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
			throws AuthenticationException {
		// we need to convert this token our user defined token
		JwtAutheticationToken jwtAutheticationToken= (JwtAutheticationToken) usernamePasswordAuthenticationToken;
		String token =jwtAutheticationToken.getToken();
		
		JwtUser jwtUser= jwtValidator.validate(token);
		if(jwtUser ==  null) {
			throw new RuntimeException("JWT token is incorrect");
		}
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		
		return new JwtUserDetails(jwtUser.getUserName(),jwtUser.getId(),token,grantedAuthorities);
		
	}

}
