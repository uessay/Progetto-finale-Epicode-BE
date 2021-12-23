package it.epicode.be05.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.epicode.be05.Repo.ProvinceRepo;
import it.epicode.be05.Service.ProvinceService;
import it.epicode.be05.model.Province;



@Service
public class ProvinceImpl implements ProvinceService {

	
	
	@Autowired
	ProvinceRepo repo;
	
	@Override
	public void create(Province entity) {
		 repo.save(entity);
		
	}

	
	
	@Override
	public void update(long id, Province entity) {
		 var us = repo.findById(id).orElseThrow();
		 us.setNameProvince(entity.getNameProvince());
		 us.setSigla(entity.getSigla());
		 repo.save(us);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Page<Province> readAll(Pageable b) {
		return repo.findAll(b);
	}

	@Override
	public Province readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	
}
