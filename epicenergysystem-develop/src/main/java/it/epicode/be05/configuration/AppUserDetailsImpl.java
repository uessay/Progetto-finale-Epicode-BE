package it.epicode.be05.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import it.epicode.be05.Repo.*;

@Service
public class AppUserDetailsImpl implements UserDetailsService {

	@Autowired
	UserRepo users;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// cerco l'utente sul database
		var user = users.findByUsername(username).orElseThrow();
		// e lo restituisco all'applicazione
		var appUser = AppUserDetails.build(user);
		return appUser;
	}

}
