package dev.jefferson.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RegistroNaoEncontradoException(String msg) {
		super(msg);
	}

}
