package it.epicode.be05.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.Repo.AddressRepo;
import it.epicode.be05.Service.AddressService;
import it.epicode.be05.model.Address;

@Service
public class AddressImpl implements AddressService {

	@Autowired
	AddressRepo repo;
	
	@Override
	public void create(Address entity) {
			 repo.save(entity);
		
	}

	@Override
	public Address readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<Address> readAll(Pageable p) {
		return repo.findAll(p);
	}

	@Override
	public void update(long id, Address entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setCap(entity.getCap());
		 us.setCivic(entity.getCivic());
		 us.setComune(entity.getComune());
		 us.setStreet(entity.getStreet());
		 repo.save(us);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

}
