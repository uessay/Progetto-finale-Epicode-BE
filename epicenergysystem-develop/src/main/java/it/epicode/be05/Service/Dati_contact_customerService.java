package it.epicode.be05.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import it.epicode.be05.model.Dati_contact_customer;

public interface Dati_contact_customerService extends  CrudService<Dati_contact_customer>{
	

	@Query("SELECT u FROM   Dati_contact_customer u ORDER BY u.dataUltimoContact DESC ")
	Page< Dati_contact_customer>  orderByDataUltimoContact(Pageable p);
	
	Page< Dati_contact_customer>  findByDataUltimoContact( LocalDate d , Pageable p);
}
