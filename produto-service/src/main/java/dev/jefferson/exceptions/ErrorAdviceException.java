package dev.jefferson.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviceException {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NullPointerException.class)
	public ErrorDTO handlerNullPointerException(NullPointerException ex) {
		return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorDTO handlerIllegalArgumentException(IllegalArgumentException ex) {
		return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public ErrorDTO handlerRegistroNaoEncontradoException(RegistroNaoEncontradoException ex) {
		return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		return ex.getAllErrors().stream()
				.map(e -> new ErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getDefaultMessage()))
				.collect(Collectors.toList());
	}

}
