package it.epicode.be05.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.epicode.be05.Impl.BillImpl;
import it.epicode.be05.Impl.UserImpl;
import it.epicode.be05.exception.ExceptionEmpty;
import it.epicode.be05.model.Bill;
import it.epicode.be05.model.Customer;
import it.epicode.be05.model.User;



@Controller
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {

	
	
	@Autowired
	public BillImpl use;
	
	
	
	//http://localhost:8080/api/bill/filter/customerid=229/?page=0&number=1
	@GetMapping("bill/filter/customerid={cust}")
	public ResponseEntity<List<Bill>> getfindByCustomer(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size , @PathVariable("cust") Customer bill ) {

		try {
		
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByCustomer(bill, page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read  getfindByCustomer"
					+ " Bill ");


		}

	}
	
	
	//http://localhost:8080/api/bill/state/?page=0&number=2&state=false
	@GetMapping("bill/filter/state")
	public ResponseEntity<List<Bill>> findByState(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ,@RequestParam(name = "state", required = false, defaultValue = "0") boolean state ) {

		try {
			
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByState(state, page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error findByState bill ");


		}

	}
	
	
	
	
	
	
	
	
	@GetMapping("bill/filter/date") //dachiedere al prof
	public ResponseEntity<List<Bill>>  findByData(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size , @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByData(date, null)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error findByState bill ");


		}

	}
	
	
	
	
	
	
	
	
	@GetMapping("bill/filter/year={year}")
	public ResponseEntity<List<Bill>>  findByYear(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size , @PathVariable("year") int year   ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByYear(year, page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error findByyear bill ");


		}

	}
	
	
	
	
	
	
	
//http://localhost:8080/api/filter/bill/minAmount=1000/maxAmount=13000?page=0&number=1
	@GetMapping("bill/filter/minAmount={minAmount}/maxAmount={maxAmount}")
	public ResponseEntity<List<Bill>>  findByAmountBetween(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber 
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size , @PathVariable("minAmount") BigDecimal minAmount , @PathVariable("maxAmount") BigDecimal maxAmount   ) {

		try {
			
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByAmountBetween(minAmount, maxAmount, page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error findByAmountBetween bill ");


		}

	}
	
	
	
	
	
	
	
	

	@GetMapping("bill/all")
	public ResponseEntity<List<Bill>> getmessAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.readAll(page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	@GetMapping("bill/{id}")
	public ResponseEntity<List<Bill>> getmessByid(@PathVariable("id") long id) {

		try {
			Bill mes =  use.readById(id);

			return new ResponseEntity(use.readById(id)  ,HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error  getbyid Bill");
			
		


		}

	}
	
	

	@PostMapping("bill")
	public ResponseEntity<List<Bill>> create(@RequestBody Bill bill) {

		try {

			 use.create(bill);
			return new ResponseEntity(bill, HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error create Bill");

		}

	}

	@PostMapping("bill/{id}")
	public ResponseEntity<List<Bill>> Update(@PathVariable("id") long id, @RequestBody Bill bill) {

		try {

			 use.update(id, bill);

			if (bill != null) {
				return new ResponseEntity(bill, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error update  Bill");


		}

	}

	@DeleteMapping("bill/{id}")
	public ResponseEntity<List<Bill>> Delete(@PathVariable("id") long id) {

		try {

			use.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			throw new ExceptionEmpty("error delete Bill");


		}

	}
	
	
}
