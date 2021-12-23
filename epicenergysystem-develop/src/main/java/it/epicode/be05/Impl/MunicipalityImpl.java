package it.epicode.be05.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable ;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.epicode.be05.Repo.MunicipalityRepo;

import it.epicode.be05.Service.MunicipalityService;

import it.epicode.be05.model.Municipality;




@Service
public class MunicipalityImpl implements MunicipalityService {

	
	@Autowired
	MunicipalityRepo repo;
	
	
	
	@Override
	public void create(Municipality entity) {
		 repo.save(entity);
		
	}



	@Override
	public Municipality readById(long id) {
		return repo.findById(id).orElseThrow();
	}



	@Override
	public Page<Municipality> readAll(Pageable p) {
		return repo.findAll(p);
	}



	@Override
	public void update(long id, Municipality entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setDenomination_in_italy(entity.getDenomination_in_italy());
		 us.setPro(entity.getPro());
		 repo.save(us);
		
	}



	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	

	

}
