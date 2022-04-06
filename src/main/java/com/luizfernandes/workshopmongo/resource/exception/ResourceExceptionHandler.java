package com.luizfernandes.workshopmongo.resource.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luizfernandes.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e , HttpServletRequest request){
		HttpStatus status =  HttpStatus.NOT_FOUND;
		StandardError err = new  StandardError(System.currentTimeMillis(), status.value(), "Não encontrato", e.getMessage(), request.getRequestURI());
		return  ResponseEntity.status(status).body(err);		
	}

}
