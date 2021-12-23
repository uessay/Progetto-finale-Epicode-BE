package it.epicode.be05.controller;

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

import it.epicode.be05.Impl.CustomerImpl;
import it.epicode.be05.Impl.MunicipalityImpl;
import it.epicode.be05.Impl.UserImpl;
import it.epicode.be05.exception.ExceptionEmpty;
import it.epicode.be05.model.Bill;
import it.epicode.be05.model.Customer;
import it.epicode.be05.model.User;



@Controller
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	
	
	@Autowired
	public CustomerImpl use;
	
	
	
	
	
	
	@GetMapping("customer/filter/data")
	public ResponseEntity<List<Customer>>findByInsertionDate(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ,@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date ) {

		try {
		
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByInsertionDate(date, page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}    


	}
	
	
	

	@GetMapping("customer/filter/name={name}") // provare 
	public ResponseEntity<List<Customer>>findByBusinessNameLike(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ,@PathVariable("name") String name ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByBusinessNameLike("%"+name +"%", page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}    
		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("customer/filter/AnnualTurnover={fatt}")
	public ResponseEntity<List<Customer>>findByAnnualTurnover(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ,@PathVariable("fatt") int fatturato ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByAnnualTurnover(fatturato , page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("customer/orderTurnover")
	public ResponseEntity<List<Customer>> orderByAnnualTurnover(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.orderByAnnualTurnover(page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	
	
	
	@GetMapping("customer/InsertionDate")
	public ResponseEntity<List<Customer>> orderByInsertionDate(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.orderByInsertionDate(page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	
	
	
	@GetMapping("customer/orderByBusinessName")
	public ResponseEntity<List<Customer>> orderByBusinessName(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.orderByBusinessName(page) ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	
	
	

	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getmessAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			, @RequestParam(name = "number", required = false, defaultValue = "0") int size ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.readAll(page)  ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Customer ");


		}

	}
	
	
	
	
	@GetMapping("customer/{id}")
	public ResponseEntity<List<Customer>> getmessByid(@PathVariable("id") long id) {

		try {
			Customer mes =  use.readById(id);

			return new ResponseEntity(use.readById(id)  ,HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error  getbyid ");
			


		}

	}
	
	

	@PostMapping("customer")
	public ResponseEntity<List<Customer>> create(@RequestBody Customer cu) {

		try {

			 use.create(cu);
			return new ResponseEntity(cu, HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error create Customer");

		}

	}

	@PostMapping("customer/{id}")
	public ResponseEntity<List<Customer>> Update(@PathVariable("id") long id, @RequestBody Customer cu) {

		try {

			 use.update(id, cu);

			if (cu != null) {
				return new ResponseEntity(cu, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error update Customer");


		}

	}

	@DeleteMapping("customer/{id}")
	public ResponseEntity<List<Customer>> Delete(@PathVariable("id") long id) {

		try {

			use.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			throw new ExceptionEmpty("error delete ");


		}

	}
	
	
	
}
