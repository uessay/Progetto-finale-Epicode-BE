package it.epicode.be05.Impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import it.epicode.be05.Repo.CustomerRepo;
import it.epicode.be05.Repo.Dati_contact_customerRepo;
import it.epicode.be05.Repo.UserRepo;
import it.epicode.be05.Service.CustomerService;
import it.epicode.be05.Service.Dati_contact_customerService;
import it.epicode.be05.model.Customer;
import it.epicode.be05.model.Dati_contact_customer;


@Service
public class Dati_contact_customerImpl  implements Dati_contact_customerService {

	@Autowired
	Dati_contact_customerRepo repo;

	@Override
	public void create(Dati_contact_customer entity) {
		repo.save(entity);
		
	}

	@Override
	public Dati_contact_customer readById(long id) {
		 var us = repo.findById(id).orElseThrow();
		 
		return null;
	}

	@Override
	public Page<Dati_contact_customer> readAll(Pageable p) {
		return repo.findAll(p);
	}

	@Override
	public void update(long id, Dati_contact_customer entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setLastnameContact(entity.getLastnameContact());
		 us.setDataUltimoContact(entity.getDataUltimoContact());
		 us.setEmailContact(entity.getEmailContact());
		 us.setNameContact(entity.getNameContact());
		 us.setNumberTelephoneContact(entity.getNumberTelephoneContact());
		 repo.save(us);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	

	@Override
	public Page<Dati_contact_customer> orderByDataUltimoContact(Pageable p) {
		
		return repo.orderByDataUltimoContact(p);
	}

	@Override
	public Page<Dati_contact_customer> findByDataUltimoContact(LocalDate d, Pageable p) {
		
		return repo.findByDataUltimoContact(d, p);
	}

	
	

}
