package dev.jefferson.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.jefferson.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionsAdvice {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorDTO handlerIllegalArgument(IllegalArgumentException ex) {
		return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public ErrorDTO handlerRegistroNaoEncontradoException(RegistroNaoEncontradoException ex) {
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
}
