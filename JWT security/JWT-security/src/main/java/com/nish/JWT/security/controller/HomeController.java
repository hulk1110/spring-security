package com.nish.JWT.security.controller;

import com.nish.JWT.security.model.JwtRequest;
import com.nish.JWT.security.model.JwtResponse;
import com.nish.JWT.security.service.UserService;
import com.nish.JWT.security.utl.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "HELLO FROM BANGALORE !!";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }

}
