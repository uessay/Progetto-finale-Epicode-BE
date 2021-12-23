package it.epicode.be05.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import it.epicode.be05.model.Customer;


public interface CustomerService extends CrudService<Customer> {
	
	

	@Query("SELECT u FROM Customer u ORDER BY u.annualTurnover DESC ")
	Page< Customer>  orderByAnnualTurnover(  Pageable p);
	
	@Query("SELECT u FROM Customer u ORDER BY u.insertionDate DESC ")
	Page< Customer>  orderByInsertionDate(Pageable p);
	
	@Query("SELECT u FROM Customer u ORDER BY  u.businessName  ")
	Page<Customer>  orderByBusinessName(Pageable p);
	
	Page<Customer>findByAnnualTurnover(int fatturato ,Pageable p);
   
   
	Page<Customer> findByInsertionDate(LocalDate d , Pageable p);
	
	Page<Customer> findByBusinessNameLike(String n , Pageable p);
	
	

}
