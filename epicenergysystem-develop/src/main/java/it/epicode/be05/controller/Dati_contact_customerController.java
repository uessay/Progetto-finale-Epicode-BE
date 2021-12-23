package it.epicode.be05.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.epicode.be05.Impl.Dati_contact_customerImpl;
import it.epicode.be05.exception.ExceptionEmpty;
import it.epicode.be05.model.Customer;
import it.epicode.be05.model.Dati_contact_customer;
import it.epicode.be05.model.User;

@Controller
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class Dati_contact_customerController {
	
	
	@Autowired
	Dati_contact_customerImpl use;
	
	
	
	
	
	
	
	@GetMapping("dati-contact/filter/DataUltimoContact")
	public ResponseEntity<List<Dati_contact_customer>> findByDataUltimoContact(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size , @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.findByDataUltimoContact(date, page) ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	
	
	
	@GetMapping("dati-contact/DataUltimoContact")
	public ResponseEntity<List<Dati_contact_customer>> orderByDataUltimoContact(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
			,@RequestParam(name = "number", required = false, defaultValue = "0") int size ) {

		try {
			//List<User> allmess =  use.readAll(null);
			
			var page = PageRequest.of(pageNumber, size);

			if (page.isUnpaged()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {
				return new ResponseEntity(use.orderByDataUltimoContact(page) ,HttpStatus.OK);

			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error read all Bill ");


		}

	}
	
	
	
	
	
	
	
	
	
	@GetMapping("dati-contact/{id}")
	public ResponseEntity<List<Dati_contact_customer>> getmessByid(@PathVariable("id") long id) {

		try {
			Dati_contact_customer mes =  use.readById(id);

			return new ResponseEntity(use.readById(id)  ,HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error  getbyid ");
			


		}

	}
	
	

	@PostMapping("dati-contact")
	public ResponseEntity<List<Dati_contact_customer>> create(@RequestBody Dati_contact_customer cu) {

		try {

			 use.create(cu);
			return new ResponseEntity(cu, HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error create Customer");

		}

	}

	@PostMapping("dati-contact/{id}")
	public ResponseEntity<List<Dati_contact_customer>> Update(@PathVariable("id") long id, @RequestBody Dati_contact_customer cu) {

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

	@DeleteMapping("dati-contact/{id}")
	public ResponseEntity<List<Dati_contact_customer>> Delete(@PathVariable("id") long id) {

		try {

			use.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			throw new ExceptionEmpty("error delete ");


		}

	}
	
	
	

}
