package it.epicode.be05.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.epicode.be05.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name="User")
@Data
@AllArgsConstructor
@Builder
public class User {
	

	
	public User() {}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	
	
	private String username;
	private String email;
	
	
	private String password;
	private String nome;
	private String cognome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", //
			joinColumns = @JoinColumn(name = "user_id"), //
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	@Builder.Default private Set<Role> roles = new HashSet<>();
	
	
	
	

}
