package it.epicode.be05.Repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be05.model.Customer;


public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {


	@Query("SELECT u FROM Customer u ORDER BY u.annualTurnover DESC ")
	Page< Customer>  orderByAnnualTurnover(  Pageable p);
	
	@Query("SELECT u FROM Customer u ORDER BY u.insertionDate DESC ")
	Page< Customer>  orderByInsertionDate(Pageable p);
	
	@Query("SELECT u FROM Customer u ORDER BY  u.businessName  ")
	Page<Customer>  orderByBusinessName(Pageable p);
	
	Page<Customer>findByAnnualTurnover(int fatturato ,Pageable p);
   
   
	Page<Customer> findByInsertionDate(LocalDate d , Pageable p);
	
	Page<Customer> findByBusinessNameLike(String n , Pageable p);
	
	//List<Customer> findAllByOrderByIndirizzolegaleComunePro();
	
}
