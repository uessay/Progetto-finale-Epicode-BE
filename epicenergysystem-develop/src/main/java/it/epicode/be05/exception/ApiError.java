package it.epicode.be05.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ApiError {
	
	 private String message;
	 private HttpStatus status;

}
