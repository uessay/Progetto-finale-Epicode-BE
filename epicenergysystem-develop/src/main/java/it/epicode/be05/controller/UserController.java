package it.epicode.be05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

import it.epicode.be05.Impl.UserImpl;
import it.epicode.be05.exception.ExceptionEmpty;
import it.epicode.be05.model.User;



@Controller
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	
	
	@Autowired
	public UserImpl use;

	@GetMapping("user")
	public ResponseEntity<List<User>> getmessAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
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

			throw new ExceptionEmpty("error read all  ");


		}

	}
	
	
	
	
	@GetMapping("user/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<User>> getmessByid(@PathVariable("id") long id) {

		try {
			User mes =  use.readById(id);

			return new ResponseEntity(use.readById(id)  ,HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error  getbyid ");
			


		}

	}
	
	

	@PostMapping("user")

	public ResponseEntity<List<User>> create(@RequestBody User user) {

		try {

			 use.create(user);
			return new ResponseEntity(user, HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error create ");

		}

	}

	@PostMapping("user/{id}")
	public ResponseEntity<List<User>> Update(@PathVariable("id") long id, @RequestBody User user) {

		try {

			 use.update(id, user);

			if (user != null) {
				return new ResponseEntity(user, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error update ");


		}

	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<List<User>> Delete(@PathVariable("id") long id) {

		try {

			use.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			throw new ExceptionEmpty("error delete ");


		}

	}
	
	
}
