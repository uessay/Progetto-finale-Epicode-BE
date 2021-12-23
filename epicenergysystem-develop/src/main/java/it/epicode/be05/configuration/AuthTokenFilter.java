package it.epicode.be05.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import it.epicode.be05.common.JwtUtils;

public class AuthTokenFilter extends OncePerRequestFilter {
	private static final Logger log = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Autowired
	private JwtUtils jwt_U;

	@Autowired
	private  AppUserDetailsImpl G_impl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
      log.info("sono qui");
		try {

 			String jwt = parsejwt(request);
			if (jwt != null && jwt_U.isTokenValid(jwt)) {
				String usurname = jwt_U.getUsernameFromToken(jwt);
				UserDetails userDetails = G_impl.loadUserByUsername(usurname);
                  log.info(userDetails.toString());
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);

			}

		} catch (Exception e) {
			log.error("errore: {}", e);

		}
		filterChain.doFilter(request, response);

	}

	private String parsejwt(HttpServletRequest req) {

		String headlerAuth = req.getHeader("Authorization");

		if (StringUtils.hasText(headlerAuth) && headlerAuth.startsWith("Bearer")) {
			return headlerAuth.substring(7, headlerAuth.length());

		}

		return null;

	}

}
