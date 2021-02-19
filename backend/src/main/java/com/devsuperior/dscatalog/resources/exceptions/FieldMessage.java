package com.devsuperior.dscatalog.resources.exceptions;

import java.io.Serializable;

// Classe auxiliar para carregar o nome do campo e as mensagem de respostas dos dados
// que não foram validados


public class FieldMessage implements Serializable{
	
	// para transformar o objeto em bytes
	
	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	private String fieldName;            
	private String message;
	
	// construtor default 
	
	public FieldMessage() {
		
	}
	
	// construtor com argumentos

	public FieldMessage(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}
	
	// Getters & setters

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
