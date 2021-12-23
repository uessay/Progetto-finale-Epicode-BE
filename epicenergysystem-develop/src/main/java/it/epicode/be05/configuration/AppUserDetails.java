package it.epicode.be05.configuration;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import it.epicode.be05.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AppUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	// Parte propria di UserDetails
	private Collection<? extends GrantedAuthority> authorities;
	private String password;
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;

	public static AppUserDetails build(User user) {
		var authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName())) 
				.collect(Collectors.toList());
		return AppUserDetails.builder() 
				.accountNonExpired(true)
				.accountNonLocked(true) 
				.authorities(authorities) 
				.credentialsNonExpired(true) 
				.enabled(true) 
				.username(user.getUsername()) 
				.password(user.getPassword())
				.build(); 
	}
}
