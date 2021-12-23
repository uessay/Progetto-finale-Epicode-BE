package it.epicode.be05.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExteptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ExceptionEmpty.class)
	protected ResponseEntity<Object> exteptionHandler(ExceptionEmpty ex) {

		ApiError Apierror = new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		return buildResponseEntity(Apierror);

	}

	private ResponseEntity<Object> buildResponseEntity(ApiError er) {

		return new ResponseEntity<>(er, er.getStatus());

	}

}
