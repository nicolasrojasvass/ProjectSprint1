package com.springboot.project.ProjectSprint1.controller;

import com.springboot.project.ProjectSprint1.controller.dto.AuthenticationRequest;
import com.springboot.project.ProjectSprint1.controller.dto.AuthenticationResponse;
import com.springboot.project.ProjectSprint1.security.JWTGenerate;
import com.springboot.project.ProjectSprint1.service.securityService.BookSecurityDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BookSecurityDetailService bookSecurityDetailService;

    @Autowired
    private JWTGenerate jwtGenerate;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody  AuthenticationRequest request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = bookSecurityDetailService.loadUserByUsername(request.getUsername());
            String jwt = jwtGenerate.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }catch(BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }
}
