package it.epicode.be05.Repo;

import java.util.Optional;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.model.User;

@Repository
public interface UserRepo extends  PagingAndSortingRepository<User, Long>{
	

	Optional<User> findByUsername(String username);

}
