package it.epicode.be05.Impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.epicode.be05.Service.UserService;
import it.epicode.be05.model.User;

import it.epicode.be05.Repo.UserRepo;


@Service
public class UserImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder encoder;

	
	@Override
	public void create(User entity) {
		var pass = entity.getPassword();
		pass = encoder.encode(pass);
		entity.setPassword(pass);
		log.info(pass);
		repo.save(entity);
		
	}

	
	@Override
	public void update(long id, User entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setCognome(entity.getCognome());
		 us.setEmail(entity.getEmail());
		 us.setNome(entity.getNome());
		 us.setUsername(entity.getUsername());
		 repo.save(us);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}


	@Override
	public User readById(long id) {
	
		return repo.findById(id).orElseThrow();
	}


	@Override
	public Page<User> readAll(Pageable p) {

		return repo.findAll(p);
	}

	

	

	

	
	
}
