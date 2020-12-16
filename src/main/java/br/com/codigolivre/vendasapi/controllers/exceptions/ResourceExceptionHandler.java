package br.com.codigolivre.vendasapi.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.codigolivre.vendasapi.services.exceptions.DatabaseException;
import br.com.codigolivre.vendasapi.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // intercepta as exceções que acontecere, para o objeto execultar o tratamento.
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //annotation indica que esse é um tratador de exceção do tipo ObjectNotFoundException.class
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) { //recebe a exceção e as informações da requisição
		String error = "ResourceNotFoundException";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}

}
