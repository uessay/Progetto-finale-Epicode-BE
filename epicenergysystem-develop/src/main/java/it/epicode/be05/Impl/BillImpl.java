package it.epicode.be05.Impl;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.Repo.BillRepo;
import it.epicode.be05.Service.BillService;
import it.epicode.be05.model.Bill;
import it.epicode.be05.model.Customer;


@Service
public class BillImpl implements BillService{

	
	@Autowired
	BillRepo repo;
	
	
	@Override
	public void create(Bill entity) {
		repo.save(entity);
		
	}

	@Override
	public Bill readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<Bill> readAll(Pageable p) {
		return repo.findAll(p);
	}

	@Override
	public void update(long id, Bill entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setYear(entity.getYear());
		 us.setData(entity.getData());
		 us.setAmount(entity.getAmount());
		 us.setNumber(entity.getNumber());
		 repo.save(us);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Page<Bill> findByCustomer(Customer c, Pageable p) {
		
		return repo.findByCustomer(c, p);
	}

	@Override
	public Page<Bill> findByState(boolean state, Pageable p) {
		
		return repo.findByState(state, p);
	}

	
	  @Override public Page<Bill> findByData(LocalDate data, Pageable p) {
	  
	  return repo.findByData(data, p); }
	 
	@Override
	public Page<Bill> findByYear(Integer state, Pageable p) {
	
		return repo.findByYear(state, p);
	}

	@Override
	public Page<Bill> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount, Pageable p) {
		
		return repo.findByAmountBetween(minAmount, maxAmount, p);
	}

	

}
