package com.devsuperior.dscatalog.dto;

// objeto simples para transportar dados, utilizando herança, e resolvendo o transporte de senhas
// apenas na inserção de dados

public class UserInsertDTO extends UserDTO{
	
	// SerialIzable para transformar o objeto em bytes
	
	private static final long serialVersionUID = 1L;
	
	// atributos basico
	
	private String password;
	
	// construtor default
	
	public UserInsertDTO() {
		super();
	}
	
	// Getters & setters

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
