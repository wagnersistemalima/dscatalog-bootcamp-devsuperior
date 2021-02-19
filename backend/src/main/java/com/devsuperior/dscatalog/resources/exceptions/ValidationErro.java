package com.devsuperior.dscatalog.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

// Essa classe vai herdar da classe StandardError todos os dados e vai ter uma lista de erros


public class ValidationErro extends StandardError{

	private static final long serialVersionUID = 1L;
	
	// atributos basico
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	// metodo para adicionar erro na lista de erros
	
	public void addErro(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
	// Getters
	

	public List<FieldMessage> getErrors() {
		return errors;
	}
	

}
