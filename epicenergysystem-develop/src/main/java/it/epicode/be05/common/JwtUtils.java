package it.epicode.be05.common;

import java.security.Signature;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.epicode.be05.configuration.AppUserDetails;




@Component
public class JwtUtils { 
	private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${jwt.secret}")
	private String securityKey;
	@Value("${jwt.expiration}")
	private long expirationMs;


	public String generateToken(Authentication auth) {
		
		AppUserDetails user = (AppUserDetails) auth.getPrincipal();
		
		var token = Jwts.builder() 
				.setSubject(user.getUsername()) 
				.setIssuedAt(new Date()) 
				.setExpiration(new Date(new Date().getTime() + expirationMs)) 
				.signWith(SignatureAlgorithm.HS512, securityKey) 
				.compact(); 
		return token;
	}


	public String getUsernameFromToken(String token) {
		var username = Jwts.parser() 
				.setSigningKey(securityKey) 
				.parseClaimsJws(token) 
				.getBody() 
				.getSubject(); 
		return username;
	}

	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser() 
			.setSigningKey(securityKey) 
			.parseClaimsJws(token); 
			return true; 
		} catch (Exception e) {
			log.error("Token non valido");
		}
		return false;
	}
}
