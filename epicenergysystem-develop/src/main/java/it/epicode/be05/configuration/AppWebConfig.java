package it.epicode.be05.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration 
@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailsService;

	@Autowired
	private UnathorizateUserJwtEntrypoint entryPoint;

	
	@Bean
	public AuthTokenFilter authenticationJwtToken() {
		return new AuthTokenFilter();
	}

	
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService)
				.passwordEncoder(getEncoder()); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http // contesto di sicurezza dell'applicazione
			.cors().and().csrf().disable() // disabilitazione di funzionalità di controllo delle richieste
			.exceptionHandling().authenticationEntryPoint(entryPoint) // installazione dell'entry point custom
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // sessione senza stato
			.authorizeRequests().antMatchers("/**") // accesso a tutte le risorse
			.permitAll().anyRequest().authenticated(); // specifica che tutte le risorse sono accessibili solo ad utenti autenticati
		
			// inserisco il filtro nella pipeline di esecuzione dei filtri di autenticazione
		http.addFilterBefore(authenticationJwtToken(), UsernamePasswordAuthenticationFilter.class);
	}
}
