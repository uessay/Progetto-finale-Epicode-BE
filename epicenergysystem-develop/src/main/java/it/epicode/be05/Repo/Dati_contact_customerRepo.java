package it.epicode.be05.Repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import it.epicode.be05.model.Dati_contact_customer;

public interface Dati_contact_customerRepo  extends  PagingAndSortingRepository<Dati_contact_customer, Long>{

	
	
	
	@Query("SELECT u FROM   Dati_contact_customer u ORDER BY u.dataUltimoContact DESC ")
	Page< Dati_contact_customer>  orderByDataUltimoContact(Pageable p);
	
	Page< Dati_contact_customer>  findByDataUltimoContact( LocalDate d , Pageable p);


}
