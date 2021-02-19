package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.services.validation.UserUpdateValid;

// objeto simples para transportar dados, utilizando herança, e resolvendo o transporte de senhas
// apenas na inserção de dados

@UserUpdateValid
public class UserUpdateDTO extends UserDTO{
	
	// SerialIzable para transformar o objeto em bytes
	
	private static final long serialVersionUID = 1L;
	
	

}
