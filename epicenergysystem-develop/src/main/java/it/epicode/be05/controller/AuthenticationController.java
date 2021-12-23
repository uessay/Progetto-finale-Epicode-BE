package it.epicode.be05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.controller.LoginRequestModel;
import it.epicode.be05.common.JwtUtils;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

	
	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	JwtUtils jwt;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginRequestModel login){
	
		var a = auth.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		
		
		a.getAuthorities(); 
		
		SecurityContextHolder.getContext().setAuthentication(a);
		
	
		var token =jwt.generateToken(a); 
		
		return new ResponseEntity<>(LoginResponseModel.builder().token(token).build(), HttpStatus.OK);
	}
}
