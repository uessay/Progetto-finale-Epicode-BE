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

import it.epicode.be05.Impl.ProvinceImpl;
import it.epicode.be05.Impl.UserImpl;
import it.epicode.be05.exception.ExceptionEmpty;
import it.epicode.be05.model.Province;
import it.epicode.be05.model.User;



@Controller
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {

	
	
	@Autowired
	public ProvinceImpl use;

	@GetMapping("province")
	public ResponseEntity<List<Province>> getmessAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber // pagina richiesta
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

			throw new ExceptionEmpty("error read all province ");


		}

	}
	
	
	
	
	@GetMapping("province/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Province>> getmessByid(@PathVariable("id") long id) {

		try {
			Province mes =  use.readById(id);

			return new ResponseEntity(use.readById(id)  ,HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error  getbyid province");
			

		}

	}
	
	

	@PostMapping("province")

	public ResponseEntity<List<Province>> create(@RequestBody Province pro) {

		try {

			 use.create(pro);
			return new ResponseEntity(pro, HttpStatus.OK);

		} catch (Exception e) {

			throw new ExceptionEmpty("error create province ");

		}

	}

	@PostMapping("province/{id}")
	public ResponseEntity<List<Province>> Update(@PathVariable("id") long id, @RequestBody Province pro) {

		try {

			 use.update(id, pro);

			if (pro != null) {
				return new ResponseEntity(pro, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {

			throw new ExceptionEmpty("error update province");


		}

	}

	@DeleteMapping("province/{id}")
	public ResponseEntity<List<Province>> Delete(@PathVariable("id") long id) {

		try {

			use.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			throw new ExceptionEmpty("error delete province");


		}

	}
	
	
}
