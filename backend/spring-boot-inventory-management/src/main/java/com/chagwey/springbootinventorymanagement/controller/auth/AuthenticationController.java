package com.chagwey.springbootinventorymanagement.controller.auth;

import com.chagwey.springbootinventorymanagement.DTO.auth.AuthenticationRequest;
import com.chagwey.springbootinventorymanagement.DTO.auth.AuthenticationResponse;
import com.chagwey.springbootinventorymanagement.model.auth.ExtendedUser;
import com.chagwey.springbootinventorymanagement.service.auth.UserDetailsServiceImpl;
import com.chagwey.springbootinventorymanagement.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsServiceImpl;

    private JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(UserDetailsServiceImpl userDetailsServiceImpl, AuthenticationManager authenticationManager
            , JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());

    }
}

