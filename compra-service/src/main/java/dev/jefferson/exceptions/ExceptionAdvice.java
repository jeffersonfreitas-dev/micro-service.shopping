package dev.jefferson.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.jefferson.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionAdvice {
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public ErrorDTO handlerRegistroNaoEncontrado(RegistroNaoEncontradoException ex) {
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
