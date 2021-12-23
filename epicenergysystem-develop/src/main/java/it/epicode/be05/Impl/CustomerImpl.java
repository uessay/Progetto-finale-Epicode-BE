package it.epicode.be05.Impl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import it.epicode.be05.Repo.CustomerRepo;
import it.epicode.be05.Repo.UserRepo;
import it.epicode.be05.Service.CustomerService;
import it.epicode.be05.model.Customer;



@Service
public class CustomerImpl  implements CustomerService {

	@Autowired
	CustomerRepo repo;

	@Override
	public void create(Customer entity) {
		repo.save(entity);
		
	}

	@Override
	public Customer readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<Customer> readAll(Pageable p) {
		return repo.findAll(p);
	}

	@Override
	public void update(long id, Customer entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setInsertionDate(entity.getInsertionDate()); 
		 us.setEmail(entity.getEmail());
		 us.setAnnualTurnover(entity.getAnnualTurnover());
		 us.setVatNumber(entity.getVatNumber());
		 us.setPec(entity.getPec());
		 us.setBusinessName(entity.getBusinessName());
		 us.setTelephone(entity.getTelephone());
		 repo.save(us);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Page<Customer> orderByAnnualTurnover(Pageable p) {
		
		return repo.orderByAnnualTurnover(p);
	}

	@Override
	public Page<Customer> orderByInsertionDate(Pageable p) {
		
		return repo.orderByInsertionDate(p);
	}

	@Override
	public Page<Customer> orderByBusinessName(Pageable p) {
		
		return repo.orderByBusinessName(p);
	}

	@Override
	public Page<Customer> findByAnnualTurnover(int fatturato, Pageable p) {
		
		return repo.findByAnnualTurnover(fatturato, p);
	}

	@Override
	public Page<Customer> findByInsertionDate(LocalDate d, Pageable p) {
	
		return repo.findByInsertionDate(d, p);
	}

	@Override
	public Page<Customer> findByBusinessNameLike(String n, Pageable p) {
		
		return repo.findByBusinessNameLike(n, p);
	}
	


}
