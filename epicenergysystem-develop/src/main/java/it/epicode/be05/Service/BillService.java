package it.epicode.be05.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.be05.model.Bill;
import it.epicode.be05.model.Customer;

public interface BillService extends CrudService<Bill>{
	
	Page<Bill> findByCustomer( Customer c , Pageable p);
	Page<Bill> findByState(boolean state , Pageable p );
	Page<Bill> findByData( LocalDate data , Pageable p );
	Page<Bill> findByYear( Integer state  , Pageable p);
	
	
	Page<Bill> findByAmountBetween( BigDecimal minAmount, BigDecimal maxAmount , Pageable p);

	

}
