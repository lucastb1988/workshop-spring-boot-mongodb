package br.com.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Sobrecarregar uma msg para a classe mãe
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
