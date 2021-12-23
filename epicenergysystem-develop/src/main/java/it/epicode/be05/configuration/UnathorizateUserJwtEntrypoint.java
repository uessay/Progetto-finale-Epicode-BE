package it.epicode.be05.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class UnathorizateUserJwtEntrypoint implements AuthenticationEntryPoint {

	
	private static final Logger log = LoggerFactory.getLogger(UnathorizateUserJwtEntrypoint.class);
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse res,
			AuthenticationException authException) throws IOException, ServletException {
		log.error("non autorizzato: {}" , authException.getMessage());
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED , "Error non aut");
		/*
		 * TODO: utente non autorizzato
		 */
		
	}

}
